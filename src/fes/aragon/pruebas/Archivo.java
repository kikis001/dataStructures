package fes.aragon.pruebas;

import fes.aragon.dinamicos.ListaSimple;
import fes.aragon.dinamicos.Nodo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Archivo {
    private ListaSimple<Byte> listaBytes;

    public Archivo() {
        listaBytes = new ListaSimple<>();
    }

    /**
     * Mpetodo para leer un archovo en bytes y almacenarlo en la lista simple
     * @param path ruta del archivo a leer
     */
    public void leerArchivo(String path) throws IOException {
        FileInputStream in = null;

        try {
            in = new FileInputStream(path);
            int byteLeido;
            // leer archivo byte por byte
            while ((byteLeido = in.read()) != -1) {
                listaBytes.append((byte) byteLeido);
            }
            System.out.println("Almacenado en lw lista");
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    /**
     * Método para imprimir los bytes almacenados en la lista
     */
    public void printBytes() {
        listaBytes.print();
    }

    /**
     * Mpetodo para leer un archovo en bytes y almacenarlo en la lista simple
     * @param path ruta del archivo a leer
     */
    public void reconstruirArchivo(String path) throws IOException {
        FileOutputStream out = null;
        Nodo<Byte> current = listaBytes.head;
        try {
            out = new FileOutputStream(path);
            while (current != null) {
                out.write(current.value);
                current = current.next;
            }
            System.out.println("Archivo contruido en " + path);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}