package Huffman;

//import lombok.Getter;
//import lombok.RequiredArgsConstructor;


//@Getter
//@RequiredArgsConstructor
public class Nodo implements Comparable <Nodo> {

    private int frecuencia;
    private Nodo nodoIzquierdo;
    private Nodo nodoDerecho;

    public Nodo(Nodo nodoIzquierdo, Nodo nodoDerecho) {
        this.nodoIzquierdo = nodoIzquierdo;
        this.nodoDerecho = nodoDerecho;
        this.frecuencia = nodoIzquierdo.getFrecuencia() + nodoDerecho.getFrecuencia();
    }
    
    public Nodo(int frecuencia) {
        this.nodoIzquierdo = null;
        this.nodoDerecho = null;
        this.frecuencia = frecuencia;
    }

    @Override
    public int compareTo(Nodo nodo) {
        return Integer.compare(getFrecuencia(), nodo.getFrecuencia());
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frequency) {
        this.frecuencia = frequency;
    }

    public Nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public void setNodoIzquierdo(Nodo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoDerecho(Nodo rightNode) {
        this.nodoDerecho = rightNode;
    }
}
