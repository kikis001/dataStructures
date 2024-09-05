import fes.aragon.dinamicos.ListaSimple;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaSimple<Integer> list = new ListaSimple<>();
        list.append(12).append(14).append(52).print();
        //list.print();

        list.asignar(5,2);
        list.print();
    }
}