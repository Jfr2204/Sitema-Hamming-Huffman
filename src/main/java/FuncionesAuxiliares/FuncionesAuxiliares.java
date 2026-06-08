package FuncionesAuxiliares;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FuncionesAuxiliares {
    
     //MANEJO DE BITS
    
    //Devuelve una subcadena de n = longitud bits desde posInicial.
    public static BitSet subCadenaBits(BitSet bitSet, int posInicial, int longitud){
        BitSet subBitSet = new BitSet(longitud);
        for(int i = 0; i < longitud; i++)
            subBitSet.set(i, bitSet.get(posInicial + i));
        return subBitSet;
    }
    
    //Concatena cadenas de bits.
    public static BitSet concatenarBits(BitSet cadena1, BitSet cadena2, int posInicioCadena2, int cantidad){
        for(int i = 0; i < cantidad; i++)
            cadena1.set(posInicioCadena2 + i, cadena2.get(i));
        return cadena1;
    }
    
    //Quita los primeros n bits del BitSet copiado.
    public static BitSet quitarBits(BitSet bitset, int tamBitset, int n){
        for(int i = 0; i < tamBitset; i++)
            bitset.set(i, bitset.get(n + i));
        return bitset;
    }
    
    //Convierte un numero entero en uno binario.
    public static BitSet enteroABinario(int numero, int longitud){
        BitSet bitSet = new BitSet(longitud);
        for(int i = longitud - 1; i >= 0; i--){
            int modulo = numero % 2;
            if(modulo == 0)
                bitSet.set(i, false);
            else
                bitSet.set(i, true);
            numero /= 2;
        }        
        return bitSet;
    }
    
    //Convierte un número en octal a una representación binaria de 8 bits. Usualmente los bytes del buffer[] están en octal.
    public static BitSet octalA8Bits(int ascii){
        BitSet bitset = new BitSet(8);
        if(ascii < 0) ascii += 256;
        for(int i = 7; i >= 0; i--){
            int modulo = ascii % 2;
            if(modulo == 0)
                bitset.set(i, false);
            else
                bitset.set(i, true);
            ascii /= 2;
        }        
        return bitset;
    }
    
    //Convierte un numero binario en un código ASCII.
    public static byte binarioAAscii(BitSet bitset){
        int valor = 0;
        int potencia = 7;
        for(int i = 0; i < 8; i++){
            if(bitset.get(i))
                valor += Math.pow(2, potencia);
            potencia--;
        }
        if(valor > 127) valor -= 256;
        return Byte.decode(String.valueOf(valor));
    }
    
    //Convierte un numero binario en uno decimal.
    public static int binarioAInt(BitSet bitset, int tamaño){
        int valor = 0;
        int potencia = tamaño - 1;
        for(int i = 0; i < tamaño; i++){
            if(bitset.get(i))
                valor += Math.pow(2, potencia);
            potencia --;
        }
        return valor;
    }
    
    //Transforma un arreglo de bytes en un bitSet de tamaño cantBytes * 8.
    public static BitSet caracteresABitSet(byte[] caracteres, int cantBytes){
        BitSet bitset = new BitSet(cantBytes * 8);
        for(int i = 0; i < cantBytes; i++)
            bitset = concatenarBits(bitset, octalA8Bits(caracteres[i]), i * 8, 8);
        return bitset;
    }
    
    //Convierte un arreglo de booleanos en un BitSet.
    public static BitSet arregloBoolABitSet(boolean[] arr, int size){
        BitSet bitSet = new BitSet(size);
        for (int i = 0; i < size; i++)
            bitSet.set(i, arr[i]);      
        return bitSet;
    }

    //Invierte el BitSet pasado por parámetros.
    public static BitSet invertirBitSet(BitSet bitSet, int tamaño){
        BitSet inverso = new BitSet(tamaño);
        for(int i = tamaño; i > 0; i--){
            inverso.set(i - 1, bitSet.get(tamaño - i));
        }
        return inverso;
    }
    
    //Convierte un String de 0s y 1s en un bitset.
    public static BitSet stringABitset(String string) {
        BitSet bitset = new BitSet(string.length());
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                bitset.set(i);
            }
        }
        return bitset;
    }
    
    //Convierte un bitset en un String de 0s y 1s.
    public static String bitsetAString(BitSet bitset) {
        String string = "";
        for(int i = 0; i < bitset.length(); i++){
            if(bitset.get(i))
                string += "1";
            else
                string += "0";
        }
        return string;
    }
    
    //Devuelve un BitSet que contiene los bits de control inicializados en 0 y los bits de información.
    public static BitSet colocarBitsControl(BitSet info, int longitud){
        BitSet bitset = new BitSet(longitud);
        int j = 0;
        for(int i = 0; i < longitud; i++){
            if(!FuncionesAuxiliares.isPotenciaDeDos(i + 1)){
                bitset.set(i, info.get(j));
                j++;
            }
        }
        return bitset;
    }
    
    public static BitSet calcularBitsControl(BitSet bitSet1, BitSet bitSet2, int bitsControl, int bitsInfo, boolean[][] matrizG){
        boolean[] aux = new boolean[bitsInfo];
        for(int i = 0; i < bitsControl; i++){
            boolean result = false;
            int pos = (int) Math.pow(2, i);
            for(int j = 0; j < bitsInfo; j++){
                aux[j] = bitSet1.get(j) && matrizG[j][i];
                result = result ^ aux[j];
            }
            bitSet2.set(pos - 1, result);
        }
        
        return bitSet2;
    }
    
    public static BitSet calcularBitParidad(BitSet bitset, int numeroHamming){
        boolean result = false;
        for(int i = 0; i < (numeroHamming - 1); i++)
            result = result ^ bitset.get(i);
        
        bitset.set(numeroHamming - 1, result);
        return bitset;
    }
    
    //MATEMATICAS
    
    //Función que genera un número aleatorio.
    public static int enteroAleatorio(int longitud){
        return new Random().nextInt(longitud);
    }
    
    //Determina si un número es potencia de 2.
    public static boolean isPotenciaDeDos(double number){
        double log = Math.log(number) / Math.log(2);
        int decimal = (int) log;
        double numero = log - decimal;
        return numero == 0.0;
    }
    
    
    //GENERACIÓN DE MATRICES
    
    //Generación de la Matriz Generadora.
    public static boolean[][] MatrizGeneradora(int cantBitsInfo, int cantBitsControl, int numeroHamming){
	        
        //filas = cantBitsInfo
	//columnas = cantBitsControl
        boolean[][] matriz = new boolean[cantBitsInfo][cantBitsControl];
	int j;
	for(int i = 0; i < cantBitsControl; i++){		
            j = 0;
            for (int k = 1; k <= numeroHamming; k++){

                //si k es potencia de dos no es de interés
                //porque que es un bit de control
                
                if(!isPotenciaDeDos(k)){

                    /*  Si se entra en la condición entonces
                        k es el bit de información en la posición j
                        que sería el bit de información j + 1. 
                        Por ejemplo, si tengo un Hamming de 7 posiciones,
                        entonces el bit de información de la primera fila
                        (j = 0) sería el bit de información 1.
                    
                        C C I C I I I
                            |
                            j
                        
                        Ejemplo de uso:
                        
                        Generación de una matriz G para 4 bits de información y 3 bits de control.
                        
                        i = 0; j = 0; k = 3
                        
                            1 2 3 4 5 6 7
                    
                            C C I C I I I
                                |
                                k
                        
                        Al llamar a la función enteroABinario, obtengo el BitSet 011. Luego coloco 
                        en la posición matriz[j][i] el bit en la posición 2 del BitSet (cantBitsControl = 3,
                        i = 0, entonces 3 - 0 - 1 = 2). En este punto, la matriz queda como se muestra a 
                        continuación:
                        
                            1       NULL    NULL
                            NULL    NULL    NULL
                            NULL    NULL    NULL
                            NULL    NULL    NULL
                    
                        La llamada a IntegerToBinary devuelve BitSets con longitud = cantBitsControl de las 
                        posiciones en las que se encuentran los bits de información. Si ponemos estos BitSets
                        uno encima del otro, obtenemos la siguiente Matriz:
                    
                            k = 3   ->  0 1 1
                            k = 5   ->  1 0 1
                            k = 6   ->  1 1 0
                            k = 7   ->  1 1 1
                    
                        La matriz obtenida es la matriz generadora pero invertida. Por eso para cada posición i 
                        de la matriz generadora, se devuelve el indice inverso de los BitSet. Por ejemplo, si i = 0
                        (lo que significa que se está generando la primera columna de la matriz), entonces se devuelven
                        los bits de los BitSet en la posición 2 (la ultima columna de la matriz formada por los BitSet).
                        
                    */
                    matriz[j][i] = enteroABinario(k, cantBitsControl).get(cantBitsControl - i - 1);
                    j++; 
                }
            }
	}
	return matriz;
    }
    
    //Generación de la Matriz Decodificadora.
    public static boolean[][] MatrizDecodificadora(int numeroHamming, int bitsControl){
        boolean[][] matriz = new boolean[numeroHamming][bitsControl];
        BitSet numero = new BitSet(bitsControl);
        
        //Se generan los numeros del 1 al n = numeroHamming en binario e invertidos.
        for(int i = 0; i < numeroHamming; i++){
            numero = enteroABinario(i + 1, bitsControl);
            for(int j = 0; j < bitsControl; j++){
                matriz[i][j] = numero.get((bitsControl - 1) - j);
            }
        }        
        return matriz;
    }
    
    
    //ARCHIVOS
    
    //Selección de un archivo.
    public static File seleccionarArchivo(){
        JFileChooser fileChooser = new JFileChooser();
        File entrada;
        if(fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION){
            entrada = fileChooser.getSelectedFile();
            return entrada;
        }
        else
            return null;
    }
    
    //Crea un archivo auxiliar y escribe en este lo contenido por la entrada.
    public static File crearArchivoAuxiliar(File entrada) throws FileNotFoundException, IOException{        
        String cantCaracteres = String.valueOf(lecturaArchivoEntrada(entrada.getAbsolutePath()).length() - 1);
        cantCaracteres = cantCaracteres.concat("\n");
        
        File salida = new File("auxiliar.txt");
        OutputStream os = new FileOutputStream(salida);
        
        os.write(cantCaracteres.getBytes());
        os.write(lecturaArchivoEntrada(entrada.getAbsolutePath()).getBytes());
        os.close();
        return salida;
    }
    
    //Escribe lo contenido por el archivo auxiliar (con dirección 'direccionEntrada') en el archivo de salida (con dirección 'direccionSalida').
    public static void leerArchivoAuxiliar(String direccionEntrada, String direccionSalida, boolean correccion) throws FileNotFoundException, IOException{
        String primeraLinea = "";
        int cantCaracteresTotal = -1;
        
        if(correccion){
            
            //En la primer linea se encuentra la cantidad de caracteres que tiene el archivo original.
            try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(direccionEntrada), "utf-8"))) {
                primeraLinea = in.readLine();
            }
            
            //Pasar de binario a int.
            cantCaracteresTotal = Integer.parseInt(primeraLinea);
        }    
        
        FileInputStream fis = new FileInputStream(direccionEntrada);
        OutputStream os = new FileOutputStream(direccionSalida);
        int caracterActual, cantCaracteresPrimeraLinea = 0,  cantCaracteresCopiados = 0;
        
        while((caracterActual = fis.read()) != -1){
            if(correccion && cantCaracteresPrimeraLinea <= primeraLinea.length()){
                //simplemente consumo la primer linea sin hacer nada, no me interesa escribirla en el output file
                cantCaracteresPrimeraLinea++;
            }
            else{
                os.write(caracterActual);
                
                /*  Explicación del if(caracterActual != 195)

                    195 es un byte de control que (supongo) usa utf-8 para advertir que lo siguiente es fuera del ASCII estandar
                    esto sucede por ejemplo con Á É Í Ó Ú á é í ó ú ñ Ñ y demas caracteres del español

                    como es byte de control, no debo contarlo como caracter copiado
                    caso contrario en el output file me quedare corto de caracteres
                */
                
                if(caracterActual != 195) 
                    cantCaracteresCopiados++;
                
                if(cantCaracteresCopiados == cantCaracteresTotal){
                    //Se copio lo necesario, el resto son 0s sin significado.
                    break;
                }
            }
        }
        fis.close();
        os.close();
    }
    
    //Lee el archivo y retorna un String con todos los caracteres.
    public static String lecturaArchivoEntrada(String direccion) throws FileNotFoundException, IOException{
        String cadena;
        StringBuffer sb = new StringBuffer();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(direccion), "utf-8"));
        while((cadena = in.readLine()) != null) {
            sb.append(cadena + "\n");
        }
        in.close();
        return sb.toString();
    }
    
    
    //Lee el archivo y retorna un String con todos los caracteres.
    public static String lecturaArchivoSalida(String direccion) throws FileNotFoundException, IOException{
        String cadena;
        StringBuilder sb = new StringBuilder();
        Charset inputCharset = Charset.forName("ISO-8859-1");
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(direccion), inputCharset));
        while((cadena = in.readLine()) != null) {
            sb.append(cadena).append("\n");
        }
        in.close();
        return sb.toString();
    }
    
    //Lee un archivo y devuelve una secuencia de bytes.
    public static ArrayList lecturaArchivoEnBytes(File archivo) throws FileNotFoundException, IOException{
        FileInputStream inputStream = new FileInputStream(archivo);
        ArrayList <Byte> bytes = new ArrayList <> ();
        byte[] caracter = new byte[1];
        while (inputStream.read(caracter) != -1)
            bytes.add(caracter[0]);
        return bytes;
    }
    
    //Genera un archivo codificado en ASCII del archivo pasado por parámetros. 
    public static void crearArchivoAscii(File auxiliarFile, File lectura) throws FileNotFoundException, IOException{
        OutputStream os = new FileOutputStream(auxiliarFile);
        String texto = lecturaArchivoEntrada(lectura.getAbsolutePath());
        byte[] bufferTexto = texto.getBytes(); //Se codifica a bytes el contenido del archivo pasado.
        os.write(bufferTexto);
        os.close();
    }
    
    //Genera un archivo de Hamming.
    public static File crearArchivoHamming(File entrada, int tipo, int bloque){
        String nombreArchivo = generarNombreHamming(entrada, tipo, bloque);
        String ubicacion = entrada.getParent() + "\\" + nombreArchivo;
        File fileOutput = new File(ubicacion);
        try {
            if (fileOutput.createNewFile()) {
                System.out.println("File created: " + fileOutput.getName());
            }
            else {
                fileOutput.delete();
                fileOutput = new File(ubicacion);
                fileOutput.createNewFile();
            }
        } catch (IOException ex) {
            Logger.getLogger(FuncionesAuxiliares.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileOutput;
    }
    
    //Genera el nombre de un archivo de Hamming.
    public static String generarNombreHamming(File entrada, int tipo, int bloque){
        String nombre = entrada.getName().split("\\.")[0];
        switch(tipo){
            case 0 ->{return nombre.concat(".HA" + String.valueOf(bloque));}
            case 1 ->{return nombre.concat(".HE" + String.valueOf(bloque));}
            case 2 ->{return nombre.concat(".DE" + String.valueOf(bloque));}
            case 3 ->{return nombre.concat(".DC" + String.valueOf(bloque));}
        }
        return "";
    }
    
    //Retorna true si la extensión es correcta.
    public static boolean controlarExtensionHamming(String nombreArchivo){
        String extension = nombreArchivo.split("\\.")[1];
        return "HA8".equals(extension) || "HA256".equals(extension) || "HA8192".equals(extension) || "HA262144".equals(extension) || "HE8".equals(extension) || "HE256".equals(extension) || "HE8192".equals(extension) || "HE262144".equals(extension);
    }
    
    public static int devolverExtensionHamming(String nombreArchivo){
        String extension = nombreArchivo.split("\\.")[1];
        switch(extension){
            case "HA8" -> {return 8;}
            case "HE8" -> {return 8;}
            case "HA256" -> {return 256;}
            case "HE256" -> {return 256;}
            case "HA8192" -> {return 8192;}
            case "HE8192" -> {return 8192;}
            case "HA262144" -> {return 262144;}
            case "HE262144" -> {return 262144;}
        }
        return 0;
    }
    
    //Genera un archivo de Huffman.
    public static File crearArchivoHuffman(File fileInput, String caso){
        String path = fileInput.getParent() + "\\" + generarNombreHuffman(fileInput, caso);
        File fileOutput = new File(path);
        try {
            if (!fileOutput.createNewFile()) {
                fileOutput.delete();
                fileOutput = new File(path);
                fileOutput.createNewFile();
            }
        } catch (IOException ex) {
            Logger.getLogger(FuncionesAuxiliares.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileOutput;
    }
    
    //Genera el nombre de un archivo de Huffman.
    private static String generarNombreHuffman(File entrada, String caso){
        String nombre = entrada.getName().split("\\.")[0];
        switch (caso) {
            case "huf" -> {return nombre.concat(".huf");}
            case "dhu" -> {return nombre.concat(".dhu");}
            case "txt" -> {return "codigos".concat(".txt");}
        }
        return "";
    }
   
    //Retorna true si la extensión es correcta.
    public static boolean controlarExtensionHuffman(String nombreArchivo){
        String extension = nombreArchivo.split("\\.")[1];
        return "huf".equals(extension);
    }
    
    public static long contarCantidadCaracteresDistintos(String contenidoArchivo) {
        return contenidoArchivo.chars().distinct().count();
    }
  
    //Retorna true si la extensión es correcta.
    public static boolean controlarExtensionCodigos(String nombreArchivo){
        String extension = nombreArchivo.split("\\.")[1];
        return "txt".equals(extension);
    }
    
    
    
    
    
    
    
    public static void printBitSet(BitSet bitset, int size){
        for(int i = 0; i<size; i++){
            if(bitset.get(i))
                System.out.print(" 1 ");
            else
                System.out.print(" 0 ");
        }
        System.out.println("");
    }
}
