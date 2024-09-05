package fes.aragon.dinamicos;

public class ListaDoble<E>{
    public NodoD<E> head;
    public NodoD<E> tail;
    private int length;

    public ListaDoble(E x) {
        head = new NodoD<>(x);
        tail = head;
        length = 1;
    }

    public ListaDoble() {
        head = null;
        tail = null;
        length = 0;
    }

    public int getLongitud(){
         return length;
    }

    public boolean esVacia() {
        if(length == 0) {
            return true;
        }
        return false;
    }

    //public ListaDoble<E> eliminarEnCabeza() {
      //
    //}

    //public NodoD<E> currentIndex(int i) {
       // if(i < 0 || i >= length) {
         //   throw new IndexOutOfBoundsException("Índice fuera de rango: " + i);
       // }
   // }
}
