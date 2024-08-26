package Fes.Aragon.Dinamicos;

public class ListaSimple {
    public Nodo head;
    public Nodo tail;
    public int length;

    /**
     * Constructor de la clase que inicializa una lista con un solo nodo.
     * @param value El valor del nodo inicial.
     */
    public ListaSimple(int value) {
        head = new Nodo(value);
        tail = head;
        length = 1;
    }

    /**
     * Método que añade un nuevo nodo con el valor especificado al final de la lista.
     * @param value El valor del nuevo nodo.
     * @return La instancia actual de ListaSimple para encadenar métodos.
     */
    public ListaSimple append(int value) {
        Nodo newNodo = new Nodo(value);
        tail.next = newNodo;
        tail = newNodo;
        length++;
        return this;
    }


    /**
     * Método que añade un nuevo nodo al inicio de la lista
     * @param value El valor del nuevo nodo.
     * @return La instancia actual de ListaSimple para encadenar métodos.
     */
    public ListaSimple prepend(int value) {
        Nodo newNodo = new Nodo(value);
        newNodo.next = head;
        head = newNodo;
        length++;
        return this;
    }

    /**
     * Método que inserta un nuevo nodo con el valor especificado en la posición indicada.
     * Si el índice es mayor o igual a la longitud de la lista, se añade al final.
     * @param i El índice en el que se debe insertar el nuevo nodo.
     * @param value El valor del nuevo nodo.
     * @return La instancia actual de ListaSimple para encadenar métodos.
     */
    public ListaSimple insert(int i, int value) {
        if(i >= length) {
            return append(value);
        }
        Nodo newNodo = new Nodo(value);
        Nodo elementPre = currentIndex(i -1);
        Nodo holdingpointer = elementPre.next;
        elementPre.next = newNodo;
        newNodo.next = holdingpointer;
        length++;
        return this;
    }

    /**
     * Mpetodo que devuelve  el nodo en el índice especificado.
     * @param i El índice del nodo deseado.
     * @return El nodo en el índice especificado.
     */
    private Nodo currentIndex(int i) {
        int counter = 0;
        Nodo current = head;
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
        Nodo currentNodo = head;
        while(currentNodo.next != null) {
            System.out.print(currentNodo.value + " -> ");
            currentNodo= currentNodo.next;
        }
        System.out.println("null");
    }
}
