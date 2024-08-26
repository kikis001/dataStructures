package Fes.Aragon.Estaticos;

import Fes.Aragon.Excepciones.IndiceFueraRango;

public class Array<E> {
    private int index = 0;
    private final Object[] l;

    /**
     * Constructor que inicializa el arreglo con el tamaño dado
     * @param n Tamaño que tendrá el arreglo
     */
    public Array(int n) {
        l = new Object[n];
    }

    /**
     * Método que valida que el indice pasado este en rango
     * @param i indice que ubica una posición en el intervalo del arreglo
     * @throws IndiceFueraRango si el indice está fueral del rango
     */
    private void validate(int i) throws IndiceFueraRango {
        if(i < 0 || i >= l.length) {
            throw new IndiceFueraRango("Fuera del invertalo");
        }
    }

    /**
     * Método que agrega elementos en el array
     * @param x elemento que se agregará al array
     * @throws IndiceFueraRango si el indice está fueral del rango
     */
    public void insertar(E x) throws IndiceFueraRango {
        validate(index);
        l[index] = (E) x;
        index++;
    }

    /**
     * Método que encuentra la posición de un elemento en caso de ser parte de la lista
     * @param x elemento que será buscando
     * @throws IndiceFueraRango si el indice está fueral del rango
     */
    public Integer localiza(int x) {
        for(int i = 0; i < l.length; i++) {
            if(l[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Método que recupera el valor en la posición i
     * @param i indice del elemento a devolver
     * @throws IndiceFueraRango si el indice está fueral del rango
     */
    public E recupera(int i) throws IndiceFueraRango {
        validate(i);
        return (E) l[i];
    }


    /**
     * Método que elimina elementos en el array
     * @param p indice del elemento a elimiar
     * @throws IndiceFueraRango si el indice está fueral del rango
     */
    public void suprime(int p) throws IndiceFueraRango {
        validate(p);
        for(int i = p; i < l.length - 1; i++) {
            l[i] = l[i+1];
        }
        l[index - 1] = null;
        index--;
    }
    /**
     * Método que recupera el valor siguiente del indice del elemento dado
     * @param i indice del elemento
     * @throws IndiceFueraRango si el indice no está en el rango
     */
    public E siguiente(int i) throws IndiceFueraRango {
        validate(i);
        if(i < index - 1) {
            return (E) l[i+1];
        }
        throw new IndiceFueraRango("No hay más elementos");
    }

    /**
     * Método que recupera el valor anterior del indice del elemento dado
     * @param i indice del elemento
     * @throws IndiceFueraRango si el indice no está en el rango
     */
    public E anterior(int i) throws IndiceFueraRango {
        validate(i);
        if(l[i-1] == null ) throw  new IndiceFueraRango("No hay elementos posteriores");
        if (i < index) {
            return (E) l[i-1];
        }
        throw  new IndiceFueraRango("No hay más elementos");
    }

    /**
     * Método que limpia el arreglo
     */
    public void limpiar() {
        if(index == 0) return;
        index = 0;
        l[0] = null;
    }

    /**
     * Método que recupera el primer elemento del arreglo
     * @throws IllegalArgumentException si no hay elementos
     */
    public E primero() throws IndiceFueraRango{
        if(index == 0) {
            throw new IndiceFueraRango("No hay elementos");
        }
        return (E) l[0];
    }

    /**
     * Método que muestra en la consola los elementos del arreglo
     */
    public void imprime() throws IndiceFueraRango{
        if(index == 0 ) throw new IndiceFueraRango("No hay elementos");
        for(int i = 0; i < index; i++) {
            System.out.println(l[i]);
        }
    }

    /**
     * Método que agrega un elemento en un indice cualquiera
     * @param x elemento que se agregará
     * @param i indice donde se asignará el valor
     * @throws IllegalArgumentException si no hay elementos
     */
    public void asignar(E x, int i) throws IndiceFueraRango {
        validate(i);
        if(i > index) {
            throw new IndiceFueraRango("Ingrese un valor en el intervalo de: " +  0 + " a " + index);
        }else if(i == index) {
            insertar(x);
        }else {
         l[i] = x;
        }
    }

    public int longitud() {
        return l.length;
    }
}
