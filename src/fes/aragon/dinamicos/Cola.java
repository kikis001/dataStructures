package fes.aragon.dinamicos;

public class Cola<E> {
    private Nodo<E> primero;
    private Nodo<E> ultimo;
    private int length;

    public Cola() {
        this.primero = null;
        this.ultimo = null;
        this.length = 0;
    }

    public Nodo<E> peek() {
        return primero;
    }

    public Cola<E> enqueue(E valor) {
        Nodo<E> nuevoNodo = new Nodo<>(valor);
        if(length == 0) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        }else {
            ultimo.next = nuevoNodo;
            ultimo = nuevoNodo;
        }
        length++;
        return this;
    }

    public Cola<E> dequeue() {
        if(length == 0) {
            primero = null;
            ultimo = null;
        }else {
            primero = primero.next;
            this.length--;
        }
        return this;
    }

    public int getLongitud() {
        return this.length;
    }

    public void imprimir() {
        Nodo<E> nodoActual = primero;
        while(nodoActual != null) {
            System.out.print(nodoActual.valor + " -> ");
            nodoActual= nodoActual.next;
        }
        System.out.println("null");
    }
}
