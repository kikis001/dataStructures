package fes.aragon.dinamicos;

public class Pila<E> {
    private Nodo<E> arriba;
    private Nodo<E> abajo;
    private int length;

    public Pila() {
        this.arriba = null;
        this.abajo = null;
        this.length = 0;
    }

    public Nodo peek() {
        return this.arriba;
    }

    public Pila<E> agregar(E valor) {
        Nodo<E> nuevoNodo = new Nodo<>(valor);
        if(length == 0) {
            arriba = nuevoNodo;
            abajo = nuevoNodo;
        }else {
            Nodo<E> sostenerPuntero = arriba;
            arriba = nuevoNodo;
            arriba.next = sostenerPuntero;
        }
        this.length++;
        return this;
    }

    public Pila<E> eliminar() {
        if(length == 0) return this;
        Nodo<E> penultimo = arriba.next;
        arriba = penultimo;
        this.length--;
        return this;
    }

    public int getLongitud() {
        return this.length;
    }

    public void imprimir() {
        Nodo<E> nodoActual = arriba;
        while(nodoActual != null) {
            System.out.print(nodoActual.valor + " -> ");
            nodoActual= nodoActual.next;
        }
        System.out.println("null");
    }

    public boolean esVacia() {
        return arriba == null;
    }
}
