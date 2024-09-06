package fes.aragon.pruebas;

import java.io.IOException;

public class PruebaArchivo {
   public static void main(String[] args) {
       try {
           Archivo archivo = new Archivo();
           archivo.leerArchivo("/home/kayaba/Documentos/trabajo3.pdf");
           archivo.printBytes();
           archivo.reconstruirArchivo("/home/kayaba/Documentos/documentoPrueba.pdf");
       }catch (IOException ex) {
           System.out.println("No existe");
       }
   }
}
