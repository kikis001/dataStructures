package Fes.Aragon.pruebas;

import Fes.Aragon.Estaticos.Array;
import Fes.Aragon.Excepciones.IndiceFueraRango;

public class PruebasArray {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(6);
        try{
           arr.insertar(1);
            arr.insertar(2);
            arr.insertar(3);
            arr.insertar(4);
            arr.insertar(5);
            arr.insertar(6);
            arr.insertar(1);




        } catch (IndiceFueraRango e) {
            System.out.println(e);
        }

    }
}
