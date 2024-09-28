package fes.aragon.dinamicos;

public class ListaDoble<E>{
    public NodoD<E> cabeza;
    public NodoD<E> cola;
    private int longitud;

    /**
     * Constructor de la clase que inicializa una lista con un solo nodo.
     * @param valor El valor del nodo inicial.
     */
    public ListaDoble(E valor) {
        NodoD<E> nuevoNodo = new NodoD<>(valor);
        cabeza = nuevoNodo;
        cola = nuevoNodo;
        longitud = 1;
    }

    /**
     * Constructor de la clase que inicializa sin ninguna valor inicial
     */
    public ListaDoble() {
        cabeza = null;
        cola = null;
        longitud = 0;
    }

    /**
     * Método que te devuelve la longitud de la lista
     */
    public int getLongitud(){
         return longitud;
    }

    /**
     * Método que retorna si la lista está vacia
     */
    public boolean esVacia() {
        return longitud == 0;
    }

    /**
     * Método que agrega un elemento al principio de la lista
     * @param valor valor que será agregado
     */
    public ListaDoble<E> insertarEnCabeza(E valor) {
        NodoD<E> nuevoNodo = new NodoD<>(valor);
        if(longitud == 0) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        }else {
            cabeza.prev = nuevoNodo;
            nuevoNodo.next = cabeza;
            cabeza = nuevoNodo;
        }
        longitud++;
        return this;
    }

    /**
     * Método que agrega un elemento al final de la lista
     * @param valor valor que será agregado
     */
    public ListaDoble<E> insertarEnCola(E valor) {
        NodoD<E> nuevoNodo = new NodoD<>(valor);
        if(longitud == 0) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        }else {
            cola.next = nuevoNodo;
            nuevoNodo.prev = cola;
            cola = nuevoNodo;
        }
        longitud++;
        return this;
    }

     /**
     * Método que elimina la cabeza de la lista doble
     */
    public ListaDoble<E> eliminarEnCabeza() {
        if(longitud == 0) {
            return this;
        } else if(longitud == 1) {
            cabeza = null;
            cola = null;
        }else {
            cabeza = cabeza.next;
            cabeza.prev = null;
        }
        longitud--;
        return this;
    }

    /**
     * Método que elimina la cola de la lista doble
     */
    public ListaDoble<E> eliminarEnCola() {
        if(longitud == 0) {
            return this;
        }else if(longitud == 1) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.prev;
            cola.next = null;
        }
        longitud--;
        return this;
    }

     /**
     * Método que regresa el valor de un indice dado
     */
    public E obtenerNodo(int i) {
        if(i < 0 || i >= longitud) throw  new IndexOutOfBoundsException("Indice fuera de rango");
        return currentIndex(i).valor;
    }

     /**
     * Método que devuelve el indice del valor a buscar
     */
    public int estaEnLista(E x){
        NodoD<E> actual = cabeza;
        int contador = 0;
        while(actual != null && !actual.valor.equals(x)) {
            actual = actual.next;
            contador++;
        }
        return actual != null ? contador : -1;
    }

    /**
     * Método que elimina un elemento en el indice dado
     */
    public ListaDoble<E> eliminaEnIndice(int i) {
        if(i < 0 || i >= longitud) {
            return this;
        }
        if(i == 0) {
            return eliminarEnCabeza();
        }
        if(i == longitud - 1) {
            return eliminarEnCola();
        }
        NodoD<E> prev = currentIndex(i-1);
        NodoD<E> remove = prev.next;
        prev.next = remove.next;
        if(remove.next != null) {
            remove.next.prev = prev;
        }
        longitud--;
        return this;
    }

    /**
     * Método que inserta un nuevo valor en el indice dado
     */
    public ListaDoble<E> insertarEnIndice(E x, int i) {
        if(i < 0 || i>= longitud) {
            throw  new IndexOutOfBoundsException("Indice fuera del rango " + i);
        }
        NodoD<E> nuevoNodo = new NodoD<>(x);
        NodoD<E> elementoPrevio = currentIndex(i-1);
        NodoD<E> sostenerPuntero = elementoPrevio.next;
        elementoPrevio.next = nuevoNodo;
        nuevoNodo.prev = elementoPrevio;
        nuevoNodo.next = sostenerPuntero;
        if(sostenerPuntero != null) {
            sostenerPuntero.prev = nuevoNodo;
        }
        longitud++;
        return this;
    }

    /**
     * Método que actualiza el valor de un elemento en la posición dada
     */
    public ListaDoble<E> asignar(E x, int i) {
        if(i < 0 || i>= longitud) {
            throw  new IndexOutOfBoundsException("Indice fuera del rango " + i);
        }
        NodoD<E> actual = currentIndex(i);
        actual.valor = x;
        return this;
    }

    private NodoD<E> currentIndex(int i) {
        if(i < 0 || i >= longitud) {
            throw new IndexOutOfBoundsException("Indice fuera de rango" + i);
        }
        NodoD<E> actual;
        if(i < longitud / 2) {
            actual = cabeza;
            for(int j = 0; j < i; j++ ) {
                actual = actual.next;
            }
        }else {
            actual = cola;
            for(int j = longitud - 1; j > i; j--) {
                actual = actual.prev;
            }
        }
        return actual;
    }

    public void imprimir() {
        NodoD<E> actual = cabeza;
        while(actual != null) {
            System.out.print(actual.valor);
            if(actual != null) {
                System.out.print(" <-> ");
            }
            actual = actual.next;
        }
        System.out.println("null");
    }

    public void asignar(E dato, E nuevo_dato, boolean cambiarTodos) {
        if(cabeza == null) return;

        NodoD<E> actual = cabeza;
        boolean encontrado = false;

        while(actual != null) {
            if(actual.valor.equals(dato)) {
                actual.valor = nuevo_dato;
                encontrado = true;
                if(!cambiarTodos) {
                    break;
                }
            }
            actual = actual.next;
        }
    }
}
