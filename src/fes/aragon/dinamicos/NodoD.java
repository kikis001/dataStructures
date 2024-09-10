package fes.aragon.dinamicos;

public class NodoD<E> {
    public E valor;
    public NodoD<E> next;
    public NodoD<E> prev;

    public NodoD(E valor) {
        this.valor = valor;
        next = null;
        prev = null;
    }
}
