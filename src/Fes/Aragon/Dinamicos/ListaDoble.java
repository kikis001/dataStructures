package Fes.Aragon.Dinamicos;


public class ListaDoble <E> extends ListaSimple<E> {

    /**
     * Constructor de la clase que inicializa una lista con un solo nodo.
     *
     * @param value El valor del nodo inicial.
     * @super (value) llama al constructor de la clase lista simple y lo inicializa
     */
    public ListaDoble(E value) {
        super(value);
        head = new Nodo<>(value);
        tail = head;
    }

    /**
     * segundo if verifica si la cabezasa contiene un valor para que prev no sea null
     *
     * @return devuelve el nodo eliminando la cabeza
     */

    public ListaDoble<E> eliminarEnCabeza() {
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
        length--;
        return this;
    }

    public ListaDoble<E> eliminarEnCola() {
        if (length == 0) {
            return this;
        } else if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            if (head != null) {// nose si si es nesesario
                tail.next = null;
            }
        }
        length--;
        return this;
    }


}



