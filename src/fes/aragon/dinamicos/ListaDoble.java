package fes.aragon.dinamicos;

public class ListaDoble<E>{
    public NodoD<E> head;
    public NodoD<E> tail;
    private int length;

    /**
     * Constructor de la clase que inicializa una lista con un solo nodo.
     * @param value El valor del nodo inicial.
     */
    public ListaDoble(E value) {
        NodoD<E> newNodo = new NodoD<>(value);
        head = newNodo;
        tail = newNodo;
        length = 1;
    }

    /**
     * Constructor de la clase que inicializa sin ninguna valor inicial
     */
    public ListaDoble() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * Método que te devuelve la longitud de la lista
     */
    public int getLongitud(){
         return length;
    }

    /**
     * Método que retorna si la lista está vacia
     */
    public boolean esVacia() {
        return length == 0;
    }

    /**
     * Método que agrega un elemento al final de la lista
     * @param value valor que será agregado
     */
    public ListaDoble<E> agregar(E value) {
        NodoD<E> newNodo = new NodoD<>(value);
        if(length == 0) {
            head = newNodo;
            tail = newNodo;
        }else {
            tail.next = newNodo;
            newNodo.prev = tail;
            tail = newNodo;
        }
        length++;
        return this;
    }

     /**
     * Método que elima la cabeza de la lista doble
     */
    public ListaDoble<E> eliminarEnCabeza() {
        if(length == 0) {
            return this;
        } else if(length == 1) {
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.prev = null;
        }
        length--;
        return this;
    }

    /**
     * Método que elima la cola de la lista doble
     */
    public ListaDoble<E> eliminarEnCola() {
        if(length == 0) {
            return this;
        }else if(length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        length--;
        return this;
    }

     /**
     * Método que regresa el valor de un indice dado
     */
    public E obtenerNodo(int i) {
        if(i < 0 || i >= length) throw  new IndexOutOfBoundsException("Indice fuera de rango");
        return currentIndex(i).value;
    }

     /**
     * Método que devuelve el indice del valor a buscar
     */
    public int estaEnLista(E x){
        NodoD<E> current = head;
        int counter = 0;
        while(current != null && !current.value.equals(x)) {
            current = current.next;
            counter++;
        }
        return current != null ? counter : -1;
    }

    /**
     * Método que elimina un elemento en indice dado
     */
    public ListaDoble<E> eliminaEnIndice(int i) {
        if(i < 0 || i >= length) {
            return this;
        }
        if(i == 0) {
            return eliminarEnCabeza();
        }
        if(i == length - 1) {
            return eliminarEnCola();
        }
        NodoD<E> prev= currentIndex(i-1);
        NodoD<E> remove = prev.next;
        prev.next = remove.next;
        if(remove.next != null) {
            remove.next.prev = prev;
        }
        length--;
        return this;
    }

    /**
     * Método que inserta un nuevo valor en el indice dado
     */
    public ListaDoble<E> insertarEnIndice(E x, int i) {
        if(i < 0 || i>= length) {
            throw  new IndexOutOfBoundsException("Indice fuera del rango " + i);
        }
        NodoD<E> newNodo = new NodoD<>(x);
        NodoD<E> elementPrev = currentIndex(i-1);
        NodoD<E> holdingpointer = elementPrev.next;
        elementPrev.next = newNodo;
        newNodo.prev = elementPrev;
        newNodo.next = holdingpointer;
        if(holdingpointer != null) {
            holdingpointer.prev = newNodo;
        }
        length++;
        return this;
    }

    /**
     * Método que actualiza el valor de un elemento en la posición dada
     */
    public ListaDoble<E> asignar(E x, int i) {
        if(i < 0 || i>= length) {
            throw  new IndexOutOfBoundsException("Indice fuera del rango " + i);
        }
        NodoD<E> current = currentIndex(i);
        current.value = x;
        return this;
    }

    private NodoD<E> currentIndex(int i) {
        if(i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("Indice fuera de rango" + i);
        }
        NodoD<E> current;
        if(i < length / 2) {
            current = head;
            for(int j = 0; j < i; j++ ) {
                current = current.next;
            }
        }else {
            current = tail;
            for(int j = length - 1; j > i; j--) {
                current = current.prev;
            }
        }
        return current;
    }

    public void print() {
        NodoD<E> current = head;
        while(current != null) {
            System.out.print(current.value);
            if(current != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println("null");
    }
}
