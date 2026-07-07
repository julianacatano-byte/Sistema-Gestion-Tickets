package Modelos;

public class ColaTickets {

    private NodoCola front;
    private NodoCola back;
    private int tamaño;

    public ColaTickets() {
        front = null;
        back = null;
        tamaño = 0;
    }

    // Encolar un ticket
    public void encolar(Ticket ticket) {

        NodoCola nuevo = new NodoCola(ticket);

        if (isEmpty()) {
            front = nuevo;
            back = nuevo;
        } else {
            back.siguiente = nuevo;
            back = nuevo;
        }

        tamaño++;
    }

    // Desencolar un ticket
    public Ticket desencolar() {

        if (isEmpty()) {
            return null;
        }

        Ticket ticket = front.dato;

        front = front.siguiente;

        if (front == null) {
            back = null;
        }

        tamaño--;

        return ticket;
    }

    // Obtener el primer ticket sin eliminarlo
    public Ticket front() {

        if (isEmpty()) {
            return null;
        }

        return front.dato;
    }

    // Saber si la cola está vacía
    public boolean isEmpty() {
        return front == null;
    }

    // Tamaño de la cola
    public int size() {
        return tamaño;
    }

    // Mostrar todos los tickets
    public String mostrar() {

        if (isEmpty()) {
            return "No hay tickets en la cola.";
        }

        StringBuilder sb = new StringBuilder();

        NodoCola actual = front;

        while (actual != null) {

            sb.append(actual.dato)
                    .append("\n-----------------------------\n");

            actual = actual.siguiente;
        }

        return sb.toString();
    }

    // Vaciar la cola
    public void vaciar() {

        front = null;
        back = null;
        tamaño = 0;
    }
}