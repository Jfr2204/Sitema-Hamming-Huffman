package Huffman;


public class Hoja extends Nodo {

    private byte character;

    public Hoja(byte caracter, int frecuencia) {
        super(frecuencia);
        this.character = caracter;
    }

    public byte getCaracter() {
        return character;
    }

    public void setCaracter(byte character) {
        this.character = character;
    }
}
