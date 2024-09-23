package fes.aragon.dinamicos;

public class ListaSimple<E> {
    public Nodo<E> cabeza;
    public Nodo<E> cola;
    private int longitud;

    /**
     * Constructor de la clase que inicializa una lista con un solo nodo.
     * @param valor El valor del nodo inicial.
     */
    public ListaSimple(E valor) {
        cabeza = new Nodo<>(valor);
        cola = cabeza;
        longitud = 1;
    }

    /**
     * Constructor de la clase que no inicializa con un nodo
     */
    public ListaSimple() {
        cabeza = null;
        cola = null;
        longitud = 0;
    }

    public int getLongitud(){
        return this.longitud;
    }

    public boolean esVacia() {
        if(longitud == 0) {
            return true;
        }
        return false;
    }

    public ListaSimple<E> eliminarEnCabeza() {
        if(longitud == 1) {
           cabeza = null;
           cola = null;
       }else {
           cabeza = cabeza.next;
       }
       longitud--;
       return this;
    }

    public ListaSimple<E> eliminarEnCola() {
        if(longitud == 0 ) {
            return this;
        }else if(longitud == 1) {
            cabeza = null;
            cola = null;
        }else {
            Nodo<E> penultimo = currentIndex(longitud - 2);
            penultimo.next = null;
            cola = penultimo;
        }
        longitud--;
        return this;
    }

    public E obtenerNodo(int i) {
        return currentIndex(i).valor;
    }

    public int estaEnLista(E x) {
        Nodo<E> nodoActual = cabeza;
        int counter = 0;
        while(nodoActual != null && !nodoActual.valor.equals(x)) {
            counter++;
            nodoActual = nodoActual.next;
        }
        return nodoActual != null ? counter : -1;
    }

    /**
     * Método que añade un valor en la cola
     * @param value El valor del nuevo nodo.
     * @return La instancia actual de ListaSimple para encadenar métodos.
     */
    public ListaSimple<E> insertarEnCola(E value) {
        Nodo<E> nuevoNodo = new Nodo<>(value);
        if(longitud == 0) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        }else {
            cola.next = nuevoNodo;
            cola = nuevoNodo;
        }
        longitud++;
        return this;
    }

    /**
     * Método que añade un nuevo nodo al inicio de la lista
     * @param value El valor del nuevo nodo.
     * @return La instancia actual de ListaSimple para encadenar métodos.
     */
    public ListaSimple<E> insertarEnCabeza(E value) {
        Nodo<E> nuevoNodo = new Nodo<>(value);
        if(longitud == 0) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        }else {
            nuevoNodo.next = cabeza;
            cabeza = nuevoNodo;
        }
        longitud++;
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
        if(i >= longitud) {
            return insertarEnCola(value);
        }
        Nodo<E> nuevoNodo = new Nodo<>(value);
        Nodo<E> elementPre = currentIndex(i -1);
        Nodo<E> sostenerPuntero = elementPre.next;
        elementPre.next = nuevoNodo;
        nuevoNodo.next = sostenerPuntero;
        longitud++;
        return this;
    }

    public void asignar(E value, int i) {
        if (i < 0 || i >= longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + i);
        }

        Nodo<E> actualizar = currentIndex(i);
        actualizar.valor = value;
    }

    public void asignar(E x) {

    }

    /**
     * Mpetodo que devuelve  el nodo en el índice especificado.
     * @param i El índice del nodo deseado.
     * @return El nodo en el índice especificado.
     */
    private Nodo<E> currentIndex(int i) {
        if (i < 0 || i >= longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + i);
        }
        int contador = 0;
        Nodo<E> actual = cabeza;
        while(contador != i) {
            actual = actual.next;
            contador++;
        }
        return actual;
    }

    /**
     * Método que imprime los valores de los nodos en la lista en formato de lista enlazada.
     * Ejemplo: "1 -> 2 -> 3 -> null"
     */
    public void imprimir() {
        Nodo<E> nodoActual = cabeza;
        while(nodoActual != null) {
            System.out.print(nodoActual.valor + " -> ");
            nodoActual= nodoActual.next;
        }
        System.out.println("null");
    }

    /**
     * Método que elimina el nodo en la posición indicada.
     * Si el índice es mayor o igual a la longitud de la lista, no realiza ninguna acción.
     * @param i El índice del nodo que se debe eliminar.
     * @return La instancia actual de ListaSimple para encadenar métodos.
     */
    public ListaSimple<E> eliminarEnIndice(int i) {
        if(i < 0 || i >= longitud) {
            return this;
        }
        if(i == 0) {
            cabeza = cabeza.next;
            if(longitud == 1) {
                cola = null;
            }
        }else {
            Nodo<E> prev = currentIndex(i -1);
            Nodo<E> remove = prev.next;
            prev.next = remove.next;
            if(i == longitud - 1) {
                cola = prev;
            }
        }
        longitud--;
        return this;
    }
}
