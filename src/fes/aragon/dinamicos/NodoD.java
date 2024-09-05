package fes.aragon.dinamicos;

public class NodoD<E> {
    public E value;
    public Nodo<E> next;
    public Nodo<E> prev;

    public NodoD(E value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
