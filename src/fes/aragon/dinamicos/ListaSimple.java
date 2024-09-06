package fes.aragon.dinamicos;

public class ListaSimple<E> {
    public Nodo<E> head;
    public Nodo<E> tail;
    private int length;

    /**
     * Constructor de la clase que inicializa una lista con un solo nodo.
     * @param value El valor del nodo inicial.
     */
    public ListaSimple(E value) {
        head = new Nodo<>(value);
        tail = head;
        length = 1;
    }

    /**
     * Constructor de la clase que no inicializa con un nodo
     */
    public ListaSimple() {
        head = null;
        tail = null;
        length = 0;
    }

    public int getLongitud(){
        return this.length;
    }

    public boolean esVacia() {
        if(length == 0) {
            return true;
        }
        return false;
    }

    public ListaSimple<E> eliminarEnCabeza() {
        if(length == 1) {
           head = null;
           tail = null;
       }else {
           head = head.next;
       }
       length--;
       return this;
    }

    public ListaSimple<E> eliminarEnCola() {
        if(length == 0 ) {
            return this;
        }else if(length == 1) {
            head = null;
            tail = null;
        }else {
            Nodo<E> penultimo = currentIndex(length - 2);
            penultimo.next = null;
            tail = penultimo;
        }
        length--;
        return this;
    }

    public E obtenerNodo(int i) {
        return currentIndex(i).value;
    }

    public int estaEnLista(E x) {
        Nodo<E> currentNodo = head;
        int counter = 0;
        while(currentNodo.value != x) {
            counter++;
            currentNodo =  currentNodo.next;
        }
        return counter;
    }

    /**
     * Método que añade un nuevo nodo con el valor especificado al final de la lista.
     * @param value El valor del nuevo nodo.
     * @return La instancia actual de ListaSimple para encadenar métodos.
     */
    public ListaSimple<E> append(E value) {
        Nodo<E> newNodo = new Nodo<>(value);
        if(length == 0) {
            head = newNodo;
            tail = newNodo;
        }else {
            tail.next = newNodo;
            tail = newNodo;
        }
        length++;
        return this;
    }

    /**
     * Método que añade un nuevo nodo al inicio de la lista
     * @param value El valor del nuevo nodo.
     * @return La instancia actual de ListaSimple para encadenar métodos.
     */
    public ListaSimple<E> prepend(E value) {
        Nodo<E> newNodo = new Nodo<>(value);
        if(length == 0) {
            head = newNodo;
            tail = newNodo;
        }else {
            newNodo.next = head;
            head = newNodo;
        }
        length++;
        return this;
    }

    /**
     * Método que inserta un nuevo nodo con el valor especificado en la posición indicada.
     * Si el índice es mayor o igual a la longitud de la lista, se añade al final.
     * @param value El valor del nuevo nodo.
     * @param i El índice en el que se debe insertar el nuevo nodo.
     * @return La instancia actual de ListaSimple para encadenar métodos.
     */
    public ListaSimple<E> insertar(E value, int i) {
        if(i >= length) {
            return append(value);
        }
        Nodo<E> newNodo = new Nodo<>(value);
        Nodo<E> elementPre = currentIndex(i -1);
        Nodo<E> holdingpointer = elementPre.next;
        elementPre.next = newNodo;
        newNodo.next = holdingpointer;
        length++;
        return this;
    }

    public void asignar(E value, int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + i);
        }

        Nodo<E> updateNodo = currentIndex(i);
        updateNodo.value = value;
    }

    public void asignar(E x) {

    }

    /**
     * Mpetodo que devuelve  el nodo en el índice especificado.
     * @param i El índice del nodo deseado.
     * @return El nodo en el índice especificado.
     */
    private Nodo<E> currentIndex(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + i);
        }
        int counter = 0;
        Nodo<E> current = head;
        while(counter != i) {
            current = current.next;
            counter++;
        }
        return current;
    }

    /**
     * Método que imprime los valores de los nodos en la lista en formato de lista enlazada.
     * Ejemplo: "1 -> 2 -> 3 -> null"
     */
    public void print() {
        Nodo<E> currentNodo = head;
        while(currentNodo != null) {
            System.out.print(currentNodo.value + " -> ");
            currentNodo= currentNodo.next;
        }
        System.out.println("null");
    }

    /**
     * Método que elimina el nodo en la posición indicada.
     * Si el índice es mayor o igual a la longitud de la lista, no realiza ninguna acción.
     * @param i El índice del nodo que se debe eliminar.
     * @return La instancia actual de ListaSimple para encadenar métodos.
     */
    public ListaSimple<E> remove(int i) {
        if(i < 0 || i >= length) {
            return this;
        }
        if(i == 0) {
            head =head.next;
            if(length  == 1) {
                tail = null;
            }
        }else {
            Nodo<E> prev = currentIndex(i -1);
            Nodo<E> remove = prev.next;
            prev.next = remove.next;
            if(i == length - 1) {
                tail = prev;
            }
        }
        length--;
        return this;
    }
}
