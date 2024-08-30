import Fes.Aragon.Dinamicos.ListaSimple;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaSimple<Integer> list = new ListaSimple<>(4);
        list.append(12).append(14).append(52).print();
        //list.print();

        list.eliminarEnCola().print();
        System.out.println(list.estaEnLista(14));
    }
}