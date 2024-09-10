package fes.aragon.algoritmos.ordenamiento;

import fes.aragon.dinamicos.ListaSimple;
import fes.aragon.dinamicos.Nodo;

public class BubbleSort {
    public void bubbleSort(ListaSimple<Integer> lista) {
        for(int i = 0; i < lista.getLongitud() - 1; i++) {
            boolean swap = false;
            Nodo<Integer> current = lista.cabeza;
            Nodo<Integer> nextNodo = lista.cabeza.next;
            for(int j = 0; j < lista.getLongitud() - i - 1; j++) {
                if(current.valor.compareTo(nextNodo.valor) > 0) {
                    Integer temp = current.valor;
                    current.valor = nextNodo.valor;
                    nextNodo.valor = temp;
                    swap = true;
                }
                current = nextNodo;
                nextNodo = nextNodo.next;
            }
            if(!swap) break;
        }
    }
}
