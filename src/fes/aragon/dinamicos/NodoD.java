package fes.aragon.dinamicos;

public class NodoD<E> {
    public E value;
    public NodoD<E> next;
    public NodoD<E> prev;

    public NodoD(E value) {
        this.value = value;
        next = null;
        prev = null;
    }
}
