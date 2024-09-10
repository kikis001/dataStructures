import fes.aragon.algoritmos.ordenamiento.BubbleSort;
import fes.aragon.dinamicos.ListaDoble;
import fes.aragon.dinamicos.ListaSimple;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaSimple<Integer> list = new ListaSimple<>();
        list.insertarEnCola(12).insertarEnCola(14).insertarEnCola(52).insertarEnCola(3).insertarEnCola(4).imprimir();

        System.out.println(list.obtenerNodo(2));
        System.out.println(list.getLongitud());
        BubbleSort bubble = new BubbleSort();
        bubble.bubbleSort(list);
        list.imprimir();

        ListaDoble<Integer> lista = new ListaDoble<>();
        lista.insertarEnCola(1).insertarEnCola(5).imprimir();
        lista.insertarEnCabeza(8).imprimir();
        lista.insertarEnIndice(2,1).imprimir();
    }
}