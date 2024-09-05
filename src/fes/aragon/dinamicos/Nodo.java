package fes.aragon.dinamicos;

public class Nodo<E> {
    public E value;
    public Nodo<E> next;

    public Nodo(E value) {
        this.value = value;
        this.next = null;
    }
}
