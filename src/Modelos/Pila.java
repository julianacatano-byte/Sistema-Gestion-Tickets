package Modelos;

public class Pila {

    NodoPila top;
    int tamaño;

    public Pila() {
        top = null;
        tamaño = 0;
    }

    // Agregar un estado
    public void push(String dato) {

        NodoPila nuevo = new NodoPila(dato);

        nuevo.siguiente = top;

        top = nuevo;

        tamaño++;
    }

    // Eliminar el último estado
    public String pop() {

        if (isEmpty()) {
            System.out.println("No hay estados para deshacer.");
            return null;
        }

        String dato = top.dato;

        top = top.siguiente;

        tamaño--;

        return dato;
    }

    // Ver estado actual
    public String peek() {

        if (isEmpty()) {
            return null;
        }

        return top.dato;
    }

    // Saber si está vacía
    public boolean isEmpty() {
        return top == null;
    }

    // Tamaño
    public int size() {
        return tamaño;
    }

    // Mostrar historial
    public void mostrar() {

        NodoPila actual = top;

        while (actual != null) {

            System.out.println(actual.dato);

            actual = actual.siguiente;
        }
    }
}
