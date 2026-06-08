package Hamming;

import FuncionesAuxiliares.FuncionesAuxiliares;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.BitSet;

public class Hamming {
    
    //CODIFICACION DE HAMMING: generarBloques -> generarCodigoHamming -> escribirEnArchivoProtegido
    
    //Hamming 8
    private static final int BITS_CONTROL_H8 = 3;
    private static final int BITS_INFO_H8 = 4;
    //Hamming 256
    private static final int BITS_CONTROL_H256 = 8;
    private static final int BITS_INFO_H256 = 247;
    //Hamming 8192
    private static final int BITS_CONTROL_H8192 = 13;
    private static final int BITS_INFO_H8192 = 8178;
    //Hamming 262144
    private static final int BITS_CONTROL_H262144 = 18;
    private static final int BITS_INFO_H262144 = 262125;
    
    
    public static int cantidadBloques;
    public static int cantidadErrores;
    public static int cantidadBitsAgregados;
    public static int erroresCorregidos;
    
    
    public static void reiniciarVariables(){
        cantidadBloques = 0;
        cantidadErrores = 0;
        cantidadBitsAgregados = 0;
        erroresCorregidos = 0;
    }
    
    
    //CODIFICACIÓN
    
    //Se generan las cadenas de bits de información.
    public static void generarBloques(File entrada, File salida, int numeroHamming, boolean error) throws FileNotFoundException, IOException {
        int bitsInfo = 0, bitsControl = 0;
        switch(numeroHamming){
            case 8 -> {
                bitsInfo = BITS_INFO_H8;
                bitsControl = BITS_CONTROL_H8;
            }
            case 256 -> {
                bitsInfo = BITS_INFO_H256;
                bitsControl = BITS_CONTROL_H256;
            }
            case 8192 -> {
                bitsInfo = BITS_INFO_H8192;
                bitsControl = BITS_CONTROL_H8192;
            }
            case 262144 -> {
                bitsInfo = BITS_INFO_H262144;
                bitsControl = BITS_CONTROL_H262144;
            }
        }
        boolean[][] matrizG = FuncionesAuxiliares.MatrizGeneradora(bitsInfo, bitsControl, numeroHamming);
        
        //BitSet principal. Una vez lleno, se procede con la Hamminización.
        BitSet principal = new BitSet(bitsInfo);
        int tamPrincipal = 0;
        
        //BitSet auxiliar. Si el BitSet principal está lleno y sobraron bits 
        //del carácter convertido en la iteración actual, entonces estos se guardan en auxiliar.
        BitSet auxiliar = new BitSet(8); 
        int tamAuxiliar = 0;
        
        //Archivo de lectura auxiliar.
        File archivoAuxiliar = FuncionesAuxiliares.crearArchivoAuxiliar(entrada);
        
        //Creación de Stream de entrada para leer el archivo.
        FileInputStream fis = new FileInputStream(archivoAuxiliar);
        
        //Creación del Stream de salida para escribir.
        OutputStream os = new FileOutputStream(salida);
        
        byte[] caracter = new byte[1];
        
        //Iteración por cada unos de los caracteres en ASCII del archivo.
        while (fis.read(caracter) != -1) {
            
            /*  La lógica para el caso de ocho bits es distinta del resto. En los otros casos, la cantidad de bits
                de información es siempre mayor a ocho. Esto permite que el BitSet principal se pueda llenar de a  
                ocho bits, es decir, de a un caracter. En el Hamming de 8, la cantidad de bits de información es cuatro. 
                Eso significa que para un solo caracteres, necesito dos BitSets.    */
            
            //Caso de Hamming de 8.
            if (numeroHamming == 8){
                
                //Se guardan los 8 bits del caracteres en auxiliar.
                auxiliar = FuncionesAuxiliares.concatenarBits(auxiliar, FuncionesAuxiliares.octalA8Bits(caracter[0]), 0, 8);
                 
                //Se guardan los primeros 4 bits en principal y se envía el bloque.
                principal = FuncionesAuxiliares.subCadenaBits(auxiliar, 0, 4);
                generarCodigoHamming(principal, bitsInfo, os, numeroHamming, error, matrizG);
                
                principal.clear();
                
                //Se guardan los ultimos 4 bits en principal y se envía el bloque.
                principal = FuncionesAuxiliares.subCadenaBits(auxiliar, 4, 4);
                generarCodigoHamming(principal, bitsInfo, os, numeroHamming, error, matrizG);
                
                principal.clear();
                auxiliar.clear();
                
            }
            else {
                
                //El BitSet auxiliar no está vacio
                if (tamAuxiliar != 0) {

                    //Se guarda en principal lo que hay en auxiliar
                    principal = FuncionesAuxiliares.concatenarBits(principal, auxiliar, 0, tamAuxiliar);
                    tamPrincipal += tamAuxiliar;
                    
                    auxiliar.clear();
                    tamAuxiliar = 0;
                }
                
                //Hay espacio para otros 8 bits en el BitSet principal.
                if (tamPrincipal + 8 <= bitsInfo) {

                    //Se colocan 8 bits en principal.
                    principal = FuncionesAuxiliares.concatenarBits(principal, FuncionesAuxiliares.octalA8Bits(caracter[0]), tamPrincipal, 8);
                    tamPrincipal += 8;
                    
                }
                else {
                    
                    //Se guardan los 8 bits del caracteres en el BitSet auxiliar.
                    auxiliar = FuncionesAuxiliares.octalA8Bits(caracter[0]);
                    tamAuxiliar = 8;

                    //Se completa principal con la cantidad de bits que faltan, extraidos de auxiliar.
                    principal = FuncionesAuxiliares.concatenarBits(principal, auxiliar, tamPrincipal, bitsInfo - tamPrincipal);

                    //Se descartan de auxiliar los bits ya copiados.
                    auxiliar = FuncionesAuxiliares.quitarBits(auxiliar, 8, bitsInfo - tamPrincipal);

                    //Se actualizan los tamaños
                    tamAuxiliar -= (bitsInfo - tamPrincipal);
                    tamPrincipal = bitsInfo;
                }

                //Si el BitSet principal está lleno, entoces el bloque está listo para enviarse.
                if (tamPrincipal == bitsInfo) {
                    generarCodigoHamming(principal, bitsInfo, os, numeroHamming, error, matrizG);
                    principal.clear();
                    tamPrincipal = 0;
                }
            }
        }
        if (tamAuxiliar != 0 || tamPrincipal != 0) {

            /*    Si se entra en este if, hay dos posibles situaciones:
                    1. Se leyeron todos los caracteres, principal llegó al tamaño para ser enviado y quedaron
                       bits en auxiliar. Se procede a copiar el contenido  de auxiliar en principal y enviarlo.
                    2. Se leyeron todos los caracteres y principal no llegó al tamaño para ser enviado. Entonces
                       se envia principal como está.
            */
            
            if (tamAuxiliar != 0){
                principal = FuncionesAuxiliares.concatenarBits(principal, auxiliar, 0, tamAuxiliar);
                tamPrincipal = tamAuxiliar;
            }
            BitSet restante = FuncionesAuxiliares.subCadenaBits(principal, 0, tamPrincipal);
            generarCodigoHamming(restante, tamPrincipal, os, numeroHamming, error, matrizG);
        }
        fis.close();
        os.close();
        archivoAuxiliar.delete();
    }
    
    //Codifica a Hamming los bloques de bits de información que recibe.
    public static void generarCodigoHamming(BitSet info, int bitsInfo, OutputStream os, int numeroHamming, boolean error, boolean[][] matrizG) throws IOException{
        int cont = 0, bitsControl = 0;
        cantidadBloques++;
        
        //Se calcula la cantidad de bits de control necesarios.
        for(int i = 1; i <= numeroHamming; i++){
            if(cont == bitsInfo)
                i = numeroHamming;
            else{
                if(FuncionesAuxiliares.isPotenciaDeDos(i))
                    bitsControl++;
                else
                    cont++;
            }
        }
        numeroHamming = bitsInfo + bitsControl + 1;
        
        //Para cada bloque de bits de información se le agregan los bits de control y el bit de paridad.
        cantidadBitsAgregados += (bitsControl + 1);
        
        BitSet cadenaHamming;
        cadenaHamming = FuncionesAuxiliares.colocarBitsControl(info, numeroHamming);
        cadenaHamming = FuncionesAuxiliares.calcularBitsControl(info, cadenaHamming, bitsControl, bitsInfo, matrizG);
        cadenaHamming = FuncionesAuxiliares.calcularBitParidad(cadenaHamming, numeroHamming);
        
        //Introducción de error.
        if(error){
            if(FuncionesAuxiliares.enteroAleatorio(2) == 1){
                cadenaHamming.flip(FuncionesAuxiliares.enteroAleatorio(numeroHamming - 1));
                cantidadErrores++;
            }
        }
        escribirEnArchivoProtegido(cadenaHamming, numeroHamming, os);
    }
    
    //Convierte a caracteres las cadenas hamminizadas y los escribe en el archivo.
    public static void escribirEnArchivoProtegido(BitSet cadenaHamming, int numeroHamming, OutputStream outputStream) throws FileNotFoundException, IOException {       
        int cantCaracteres = numeroHamming / 8;
        byte[] caracteres = new byte[cantCaracteres];
        
        for (int i = 0; i < cantCaracteres; i++)
            caracteres[i] = FuncionesAuxiliares.binarioAAscii(cadenaHamming.get(i * 8, (i + 1) * 8));
        outputStream.write(caracteres);
    }
    

    //DECODIFICACIÓN 
    
    //Se obtienen los bloques de bits Hamminizados.
    public static void obtenerBloques(File entrada, File salida, int numeroHamming, boolean correccion) throws FileNotFoundException, IOException{
        //Cantidad de bytes por bloque.
        int cantCaracteres = numeroHamming / 8;
        int bitsInfo = 0, bitsControl = 0, j = 0, i; //declaracion de i innecesaria?
        
        //Se calculan las cantidades de los bits de información y control.
        for(i = 1; i < numeroHamming; i++){
            if(FuncionesAuxiliares.isPotenciaDeDos(i))
                bitsControl++; 
            else 
                bitsInfo++;
        }
        boolean[][] matrizD = FuncionesAuxiliares.MatrizDecodificadora(numeroHamming - 1, bitsControl);
        
        //Creación del fis.
        FileInputStream fis = new FileInputStream(entrada);
        
        byte[] caracteres = new byte[cantCaracteres];
        byte[] caracter = new byte[1];
        int contadorBitsInfo, posInfo;
        
        //BitSet que contendrá los bits de información.
        BitSet info;
        
        BitSet principal = new BitSet(8);
        int tamPrincipal = 0;
        BitSet auxiliar = new BitSet(8);
        int tamAuxiliar = 0;
        
         //Archivo de escritura auxiliar.
        File archivoAuxiliar = new File("auxiliar2.txt");
        
        //Creación del os.
        OutputStream os = new FileOutputStream(archivoAuxiliar);
                
        
        //Iteración por cada uno de los caracteres del archivo codificado.
        while (fis.read(caracter) != -1){
            
            //Se almamena cada uno de los bytes del archivo en el arreglo caracteres.
            caracteres[j] = caracter[0];
            
            /*  La condición del siguiente if se cumple cuando el arreglo caracteres se llenó con una cantidad de bytes igual a la variable cantBites.
                La variable cantBytes es el número de bytes que se necesitan para representar una cadena Hamming de una longitud dada. Por ejemplo, 
                si las cadenas de Hamming son de 256 bits, entonces cantBytes es de 32 bytes. */
            if(j == cantCaracteres - 1) {
                
                //Se llama a la función de decodificación y se le asignan los bits del información al BitSet info.
                info = decodificarCodigoHamming(FuncionesAuxiliares.caracteresABitSet(caracteres, cantCaracteres), numeroHamming, bitsInfo, bitsControl, correccion, matrizD);

                //Esta variable guarda la posición del primer bit que no ha sido tomado del BitSet info.
                posInfo = 0;

                //Esta variable guarda la cantidad de bits que ya no han sido tomados del BitSet info.
                contadorBitsInfo = bitsInfo;

                /*  Al igual que en la codificación, la lógica del caso de Hamming de 8 en la decodificación también
                    es distinta del resto. Los bloques de bits de información son de cuatro bits, y son necesarios 
                    ocho bits para enviarlos al archivo. */

                //Caso de Hamming de 8
                if(numeroHamming == 8){

                    //Se colocan los 4 bits del BitSet info en el BitSet principal.
                    for(i = 0; i < bitsInfo; i++)
                        principal.set(tamPrincipal + i, info.get(i));

                    tamPrincipal += 4;

                    //Si se completaron 2 iteraciones, entonces hay 8 bits en el BitSet principal.
                    if(tamPrincipal == 8){
                        tamPrincipal = 0;

                        //Se envía principal a la función que lo coloca en el archivo.
                        escribirEnArchivoDecodificado(principal, os);
                    }
                } 
                else {

                    //El bistSet auxiliar no está vacio.
                    if(tamAuxiliar != 0){

                        //Se guardan en principal los bits del BitSet auxiliar.
                        for(i = 0; i < tamAuxiliar; i++){
                            principal.set(i, auxiliar.get(i));
                        }
                        tamPrincipal = tamAuxiliar;
                        tamAuxiliar = 0;

                        //Completo principal con la cantidad de bits que falten para llegar a ocho.
                        //Estos bits restantes son tomados del BitSet info.
                        for(i = 0; i < 8 - tamPrincipal; i++){
                            principal.set(tamPrincipal + i, info.get(i));
                        }

                        posInfo += i;
                        contadorBitsInfo -= i;
                        tamPrincipal = 0;

                        //Se envía principal a la función que lo coloca en el archivo.
                        escribirEnArchivoDecodificado(principal, os);
                    }

                    //Para cada bloque de bits de información, se colocan los bits 
                    //en el BitSet principal de tomados de a 8.
                    while(contadorBitsInfo >= 8){
                        for(i = 0; i < 8; i++){
                            principal.set(i, info.get(posInfo + i));
                        }
                        posInfo += 8;
                        contadorBitsInfo -= 8;

                        //Se envía principal a la función que lo coloca en el archivo.
                        escribirEnArchivoDecodificado(principal, os);
                    }

                    //Quedan menos de 8 bits en el BitSet info.
                    if(contadorBitsInfo != 0){

                        //Se guardan en el BitSet auxiliar los bits que sobraron del BitSet info.
                        for(i = 0; i < contadorBitsInfo; i++){
                            auxiliar.set(i, info.get(posInfo + i));
                        }
                        tamAuxiliar = contadorBitsInfo;
                    }
                }
                j = 0;
            }
            else {
                j++;
            }
        }
        
        /*  La condición del siguiente if se cumple si la cantidad de bytes en el arreglo caracteres es menor que el valor de la variable
            cantBytes. Eso significa que la cantidad de bits en el archivo no es suficiente para completar todos los bloques de bits. Por ejemplo,
            si el archivo ha sido codificado con bloques de 8192 bits, y el archivo original tenía 1320 caracteres, entonces en el archivo codificado
            hay 10 560 bits de información (1320 * 8) y, por lo tanto, puedo completar un solo bloque de 8192 bits. */
        
        if(j < cantCaracteres - 1){
            
            //Se calcula la cantidad de bits restantes. La variable j es la cantidad de bytes que hay en el arreglo caracteres.
            numeroHamming = j * 8;
            bitsInfo = 0;
            bitsControl = 0;
            
            //En base a la cantidad de bits restantes se calculan las cantidades de bits de información y control.
            for(i = 1; i < numeroHamming; i++){
                if(FuncionesAuxiliares.isPotenciaDeDos(i))
                    bitsControl++; 
                else 
                    bitsInfo++;
            }
            
            //Se llama a la función de decodificación pasandole la cantidad de bits de información y control correspondientes a la cantidad de bits restantes.
            info = decodificarCodigoHamming(FuncionesAuxiliares.caracteresABitSet(caracteres, cantCaracteres), numeroHamming, bitsInfo, bitsControl, correccion, matrizD);
            
            posInfo = 0;
            contadorBitsInfo = bitsInfo;
            if(tamAuxiliar != 0){
                for(i = 0; i < tamAuxiliar; i++){
                    principal.set(i, auxiliar.get(i));
                }
                tamPrincipal = tamAuxiliar;
                for(i = 0; i < 8 - tamPrincipal; i++){
                    principal.set(tamPrincipal + i, info.get(i));
                }

                posInfo += i;
                contadorBitsInfo -= i;
                escribirEnArchivoDecodificado(principal, os);
            }
            while(contadorBitsInfo >= 8){
                for(i = 0; i < 8; i++){
                    principal.set(i, info.get(posInfo + i));
                }
                posInfo += 8;
                contadorBitsInfo -= 8;
                escribirEnArchivoDecodificado(principal, os);
            }
        }
        FuncionesAuxiliares.leerArchivoAuxiliar(archivoAuxiliar.getAbsolutePath(), salida.getAbsolutePath(), correccion);
        fis.close();
        os.close();
        archivoAuxiliar.delete();
    }
    
    //Decodifica las cadenas Hamminizadas que recibe.
    public static BitSet decodificarCodigoHamming(BitSet cadenaHamming, int numeroHamming, int bitsInfo , int bitsControl, boolean correccion, boolean [][] matrizD){
        BitSet info = new BitSet(bitsInfo);
        
        boolean[] sindrome = new boolean[bitsControl];
        boolean[] aux = new boolean[numeroHamming];
        boolean result;
        
        //Se calcula el sindrome sin contar el bit de paridad.
        for(int i = 0; i < bitsControl; i++){
            result = false;
            for(int j = 0; j < (numeroHamming - 1); j++){
                aux[j] = cadenaHamming.get(j) && matrizD[j][i];
                result = result ^ aux[j];
            }
            sindrome[i] = result;
        }

        //Se convierte a BitSet el arreglo de booleanos sindrome.
        BitSet sindromeBitSet = FuncionesAuxiliares.arregloBoolABitSet(sindrome, bitsControl);
        
        //Se invierte el sindrome.
        sindromeBitSet = FuncionesAuxiliares.invertirBitSet(sindromeBitSet, bitsControl);

        //Se convierte a entero el sindrome para obtener la posición del error.
        int posError = FuncionesAuxiliares.binarioAInt(sindromeBitSet,bitsControl);

        //Si el sindrome es mayor a 0, entonces hay un error que debe ser corregido.
        if(correccion){
            if(posError != 0){
                
                //Se le resta 1 al sindrome para obtener el indice. 
                cadenaHamming.flip(posError - 1);
                erroresCorregidos++;
            }
        }
        int contadorOutput = 0;
        
        //Se guardan los bits de información en el BitSet info.
        for(int i = 2; i < numeroHamming; i++){
            if(!FuncionesAuxiliares.isPotenciaDeDos(i + 1)){
                info.set(contadorOutput, cadenaHamming.get(i));
                contadorOutput++;
            }
        }
        return info;
    }

    //Convierte a caracteres las cadenas de bits y las escribe en el archivo.
    public static void escribirEnArchivoDecodificado(BitSet outputBitset, OutputStream outputStream) throws FileNotFoundException, IOException{
        //escribe 8 bits = 1 byte
        byte[] caracter = new byte[1];
        caracter[0] = (byte) FuncionesAuxiliares.binarioAAscii(outputBitset);
        outputStream.write(caracter);
    }
}
