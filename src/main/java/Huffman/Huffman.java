package Huffman;

import FuncionesAuxiliares.FuncionesAuxiliares;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

import static java.util.Objects.requireNonNull;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Huffman {

    private Nodo raiz;
    private final ArrayList <Byte> texto;
    private Map <Byte, Integer> frecuenciasDeCaracteres;
    private final Map <Byte, String> codigosDeHuffman;


    public Huffman(ArrayList texto) {
        this.texto = texto;
        llenarMapaDeFrecuencias();
        codigosDeHuffman = new HashMap<>();
    }
    
    public Huffman() {
        this.texto = null;
        codigosDeHuffman = new HashMap<>();
    }
    
    //COMPRESIÓN
    
    //Le asigna una frecuencia a cada uno de los caracteres del texto y .
    private void llenarMapaDeFrecuencias() {
        frecuenciasDeCaracteres = new HashMap<>();
        texto.forEach(character -> {
            Integer integer = frecuenciasDeCaracteres.get(character);
            frecuenciasDeCaracteres.put(character, integer != null ? integer + 1 : 1);
        });
    }
    
    //Genera el arbol de Huffman y guarda en el mapa los códigos con sus caracteres.
    private void generarCodigosDeHuffman(Nodo nodo, String codigo) {
        if (nodo instanceof Hoja) {
            codigosDeHuffman.put(((Hoja) nodo).getCaracter(), codigo);
            return;
        }
        generarCodigosDeHuffman(nodo.getNodoIzquierdo(), codigo.concat("0"));
        generarCodigosDeHuffman(nodo.getNodoDerecho(), codigo.concat("1"));
    }
    
    //Escribe en el archivo los códigos con sus caracteres.
    public void escribirCodigosEnArchivo(File archivo) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(archivo);
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        codigosDeHuffman.forEach((caracter, codigo) ->{
            try {
                bw.write(caracter + " " + codigo);
                bw.newLine();
            } catch (IOException ex) {
                Logger.getLogger(Huffman.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bw.close();
    }

    //Genera el texto comprimido.
    public void comprimir(File salida) throws IOException {
        OutputStream os = new FileOutputStream(salida);
        Queue<Nodo> queue = new PriorityQueue<>();
        frecuenciasDeCaracteres.forEach((caracter, frecuencia) ->
                queue.add(new Hoja(caracter, frecuencia))
        );
        while (queue.size() > 1) {
            queue.add(new Nodo(queue.poll(), requireNonNull(queue.poll())));
        }
        generarCodigosDeHuffman(raiz = queue.poll(), "");
        escribirEnArchivoComprimido(getTextoComprimido(), os);
    }
    
    //Devuelve el texto comprimido.
    private String getTextoComprimido() {
        StringBuilder sb = new StringBuilder();
        texto.forEach(caracter -> {
            sb.append(codigosDeHuffman.get(caracter));
        });
        return sb.toString();
    }
    
    //Escribe en el archivo el texto comprimido.
    public void escribirEnArchivoComprimido(String textoComprimido, OutputStream os) throws FileNotFoundException, IOException{
        int cadenaBits, cont = 0;
        char [] bits = textoComprimido.toCharArray();
        String codigo = "";
        byte [] caracter = new byte[1];
        
        //Se calcula la cantidad de bits que tendrá el ultimo byte.
        char ultimo = Character.forDigit(bits.length % 8, 10);
        
        //Se calcula el codigo ASCII del numero en la variable "ultimo" y se lo escribe como el primer caracter el archivo.
        os.write((byte) ultimo);
        
        /* Iteración por cada uno de los bits del texto comprimido. Cuando cont llega a 8, se escribe un caracter
           en el archivo. */
        for(int i = 0; i < bits.length; i ++){
            if(cont == 8){
                cadenaBits = Integer.parseInt(codigo, 2);
                caracter[0] = (byte) cadenaBits;
                os.write(caracter);
                codigo = "";
                cont = 0;
            }
            codigo += bits[i];
            cont++;
        }
        
        //Si cont es mayor a 0, significa que sobraron bits. La variable "ultimo" guarda esta cantidad de bits. 
        if(cont > 0){
            cadenaBits = Integer.parseInt(codigo, 2);
            caracter[0] = (byte) cadenaBits;
            os.write(caracter);
        }
    }
    
    
    //DESCOMPRESIÓN
    
    //Llena el mapa con los códigos de Huffman y sus respectivos caracteres obtenidos del entrada.
    public void obtenerCodigosDeHuffman(File entrada) throws FileNotFoundException{
        codigosDeHuffman.clear();
        Scanner scanner = new Scanner(entrada);
        String[] par;
        
        //Iteración por cada una de las líneas del archivo.
        while (scanner.hasNextLine()){
            
            /* Cada línea del archivo es de la forma < caracter codigo >. Un espacio en blanco separa
               el caracter del codigo. En el arreglo de Strings "par" se guarda el caracter en la primer 
               posición y el código en la última. Por último, se agrega el par al mapa. */
            par = scanner.nextLine().split(" ");
            codigosDeHuffman.put(Byte.parseByte(par[0]), par[1]);
        }
    }

    //Obtiene el texto original usando la tabla con los códigos de Huffman.
    public void descomprimirConTabla(File entrada, File salida) throws IOException {
        int cantCaracteres = 0;
        byte[] caracter = new byte[1];
        String cadenaBits;
        String textoComprimido = "";
        
        //Se determina la cantidad de caracteres del archivo.
        FileInputStream fis = new FileInputStream(entrada);
        while (fis.read(caracter) != -1){
            cantCaracteres++;
        }
        
        //Se reinicia el FileInputStream.
        fis.close();
        fis = new FileInputStream(entrada);
        
        //Se lee el primer bit, que es el numero de bits con el que fue escrito el último bit.
        fis.read(caracter);
        int ultimo = Character.getNumericValue((char) caracter[0]);
        
        //Se itera desde el segundo bit hasta el penúltimo bit del archivo.
        for(int i = 2; i <= cantCaracteres - 1; i ++){
            fis.read(caracter);
            
            //En esta línea de codigo se convierte un byte en un String de 0s y 1s de 8 bits de longitud.
            cadenaBits = String.format("%8s", Integer.toBinaryString(caracter[0] & 0xFF)).replace(' ', '0');
            textoComprimido += cadenaBits;
        }
        
        /* Se lee el último bit del archivo. Si la variable ultimo es mayor a 0, entonces el ultimo bit fue escrito con
           menos de 8 bits. Si la variable ultimo es igual a 0, entonces la cantidad de bits en el texto comprimido era multiplo de
           8 y, por lo tanto, el último bit fue escrito con 8 bits. */
        fis.read(caracter);
        if(ultimo > 0)
            cadenaBits = String.format("%" + ultimo + "s", Integer.toBinaryString(caracter[0] & 0xFF)).replace(' ', '0');
        else
            cadenaBits = String.format("%8s", Integer.toBinaryString(caracter[0] & 0xFF)).replace(' ', '0');
        textoComprimido += cadenaBits;
        
        //En este String se guardan los códigos de Huffman.
        String codigo = "";
        OutputStream os = new FileOutputStream(salida);
       
        //Se itera por cada uno de los caracteres (Que representan bits) del texto comprimido.
        for (char bit : textoComprimido.toCharArray()) {
            
            //Cada bit se concatena en el String codigo.
            codigo = codigo + bit;
            
            /* Se compara el String con cada uno de los codigos de Huffman. Si hay una coincidencia se escribe
               en el archivo el caracter correspondiente a ese código y se vacía el String. */
            for(var par : codigosDeHuffman.entrySet()){
                if(codigo.equals(par.getValue())){
                   os.write(par.getKey());
                   codigo = "";
                }
            }
        }
        fis.close();
        os.close();
    }
    
    
    //Obtiene el texto original usando el arbol de Huffman.
    public void descomprimirConArbol(File entrada, File salida) throws IOException {
        String textoComprimido = FuncionesAuxiliares.lecturaArchivoEntrada(entrada.getAbsolutePath());
        OutputStream outputStream = new FileOutputStream(salida);
        StringBuilder sb = new StringBuilder();
        Nodo actual = raiz;
        for (char character : textoComprimido.toCharArray()) {
            actual = character == '0' ? actual.getNodoIzquierdo() : actual.getNodoDerecho();
            if (actual instanceof Hoja) {
                sb.append((char) ((Hoja) actual).getCaracter());
                outputStream.write(((Hoja) actual).getCaracter());
                actual = raiz;
            }
        }
    } 
}
