package Modelos;

public class ColaTickets {

    NodoCola front;
    NodoCola back;
    int tamaño;

    public ColaTickets() {
        front = null;
        back = null;
        tamaño = 0;
    }

    // Encolar
    public void encolar(Ticket dato) {

        NodoCola nuevo = new NodoCola(dato);

        if (isEmpty()) {
            front = nuevo;
            back = nuevo;
        } else {
            back.siguiente = nuevo;
            back = nuevo;
        }

        tamaño++;
    }


    public Ticket desencolar() {

        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }

        Ticket dato = front.dato;

        front = front.siguiente;

        if (front == null) {
            back = null;
        }

        tamaño--;

        return dato;
    }

    // Primer elemento
    public Ticket front() {

        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }

        return front.dato;
    }

    // ¿Está vacía?
    public boolean isEmpty() {
        return front == null;
    }

    // Tamaño
    public int size() {
        return tamaño;
    }

    // Mostrar
    public void mostrar() {

        NodoCola actual = front;

        while (actual != null) {

            System.out.println(actual.dato.getNombreCliente());
            System.out.println(actual.dato.getAsunto());
            System.out.println(actual.dato.getPrioridad());
            System.out.println(actual.dato.getEstado());

            actual = actual.siguiente;
        }
    }
}