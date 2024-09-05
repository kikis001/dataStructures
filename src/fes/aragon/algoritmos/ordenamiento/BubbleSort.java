package fes.aragon.algoritmos.ordenamiento;

import fes.aragon.dinamicos.ListaSimple;
import fes.aragon.dinamicos.Nodo;

public class BubbleSort {
    public void bubbleSort(ListaSimple<Integer> lista) {
        for(int i = 0; i < lista.getLongitud() -1; i++) {
            boolean swap = false;
            Nodo<Integer> current = lista.head;
            Nodo<Integer> nextNodo = lista.head.next;
            for(int j = 0; j < lista.getLongitud() - i - 1; j++) {
                if(current.value.compareTo(nextNodo.value) > 0) {
                    Integer temp = current.value;
                    current.value = nextNodo.value;
                    nextNodo.value = temp;
                    swap = true;
                }
                current = nextNodo;
                nextNodo = nextNodo.next;
            }
            if(!swap) break;
        }
    }
}
