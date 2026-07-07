package Modelos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public Ticket peek() {
        return cola.peek();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public List<Ticket> getTodos() {
        return new ArrayList<>(cola);
    }

    public void mostrarPendientes() {
        for (Ticket ticket : cola) {
            System.out.println(ticket.getNombreCliente() +
                    " - " + ticket.getAsunto() +
                    " - " + ticket.getEstado());
        }
    }
}