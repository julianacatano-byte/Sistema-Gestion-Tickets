package Estructuras;

import Modelos.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ColaTickets {
    private NodoCola front;
    private NodoCola rear;

    public void encolar(Ticket ticket) {
        NodoCola nuevo = new NodoCola(ticket);
        if (rear != null) {
            rear.siguiente = nuevo;
        }
        rear = nuevo;
        if (front == null) {
            front = rear;
        }
    }

    public Ticket desencolar() {
        if (front == null) return null;
        Ticket ticket = front.dato;
        front = front.siguiente;
        if (front == null) {
            rear = null;
        }
        return ticket;
    }

    public Ticket peek() {
        return (front != null) ? front.dato : null;
    }

    public boolean estaVacia() {
        return front == null;
    }

    public List<Ticket> getTodos() {
        List<Ticket> lista = new ArrayList<>();
        NodoCola actual = front;
        while (actual != null) {
            lista.add(actual.dato);
            actual = actual.siguiente;
        }
        return lista;
    }

    public void mostrarPendientes() {
        NodoCola actual = front;
        while (actual != null) {
            Ticket t = actual.dato;
            System.out.println(t.getNombreCliente() + " - " + t.getAsunto() + " - " + t.getEstado());
            actual = actual.siguiente;
        }
    }
}
