import fes.aragon.algoritmos.ordenamiento.BubbleSort;
import fes.aragon.dinamicos.ListaDoble;
import fes.aragon.dinamicos.ListaSimple;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaSimple<Integer> list = new ListaSimple<>();
        list.append(12).append(14).append(52).append(3).append(4).print();

        System.out.println(list.obtenerNodo(2));
        System.out.println(list.getLongitud());
        BubbleSort bubble = new BubbleSort();
        bubble.bubbleSort(list);
        list.print();

        ListaDoble<Integer> lista = new ListaDoble<>();
        lista.agregar(1).agregar(5).agregar(8).eliminaEnIndice(2).insertarEnIndice(2, 1).eliminarEnCabeza().print();
    }
}