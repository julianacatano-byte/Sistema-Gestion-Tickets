package Modelos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ColaTickets {

    private Queue<Ticket> cola;

    public ColaTickets() {
        cola = new LinkedList<>();
    }

    public void encolar(Ticket ticket) {
        cola.offer(ticket);
    }

    public Ticket desencolar() {
        return cola.poll();
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
