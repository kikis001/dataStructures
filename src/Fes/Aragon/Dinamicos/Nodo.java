package Fes.Aragon.Dinamicos;

public class Nodo<E> {
    public E value;
    public Nodo<E> next;
    public  Nodo <E> prev;

    public Nodo(E value) {
        this.value = value;
        this.next = null;
        this.prev=null;
    }
}
