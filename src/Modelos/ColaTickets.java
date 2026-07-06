package Modelos;

import java.util.LinkedList;
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

    public void mostrarPendientes() {
        for (Ticket ticket : cola) {
            System.out.println(ticket.getNombreCliente() +
                    " - " + ticket.getAsunto() +
                    " - " + ticket.getEstado());
        }
    }
}
