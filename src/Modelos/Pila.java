package Modelos;

public class Pila {

    private NodoPila top;
    private int tamaño;

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
            return null;
        }

        String dato = top.dato;
        top = top.siguiente;
        tamaño--;

        return dato;
    }

    // Ver el estado actual
    public String peek() {

        if (isEmpty()) {
            return null;
        }

        return top.dato;
    }

    // ¿Está vacía?
    public boolean isEmpty() {
        return top == null;
    }

    // Cantidad de estados
    public int size() {
        return tamaño;
    }

    // Devuelve el historial en un String
    public String mostrar() {

        if (isEmpty()) {
            return "No hay historial.";
        }

        StringBuilder sb = new StringBuilder();

        NodoPila actual = top;

        while (actual != null) {

            sb.append(actual.dato).append("\n");

            actual = actual.siguiente;
        }

        return sb.toString();
    }
}