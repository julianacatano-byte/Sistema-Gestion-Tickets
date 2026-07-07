package Controladores;

import Estructuras.ListaDobleEnlazada;
import Modelos.ColaTickets;
import Modelos.Ticket;
import Vistas.GestionarTicketsEnAtencion;
import Vistas.IniciarAtencionDelSiguienteTicket;
import Vistas.PanelPrincipal;

import javax.swing.*;
import java.util.List;

public class PanelPrincipalController {
    private final List<Ticket> tickets;
    private final ColaTickets colaTickets;
    private final ListaDobleEnlazada listaAtencion;
    private PanelPrincipal vista;

    public PanelPrincipalController(List<Ticket> tickets, ColaTickets colaTickets, ListaDobleEnlazada listaAtencion) {
        this.tickets = tickets;
        this.colaTickets = colaTickets;
        this.listaAtencion = listaAtencion;
    }

    public void mostrarPanel() {
        this.vista = new PanelPrincipal(this);
        this.vista.mostrar();
    }

    public void onAtenderTicketClick() {
        handleAtenderTicketClick();
    }

    public void onConsultarTicketPendienteClick() {
        handleConsultarTicketPendienteClick();
    }

    public void onConsultarHistorialClick() {
        handleConsultarHistorialClick();
    }

    public void onGestionarTicketsEnAtencionClick() {
        GestionarTicketsEnAtencion gestionar = new GestionarTicketsEnAtencion(listaAtencion);
        gestionar.mostrar();
    }

    private void handleAtenderTicketClick() {
        if (colaTickets.estaVacia()) {
            JOptionPane.showMessageDialog(
                    vista.getPanel(),
                    "No hay tickets pendientes por atender.",
                    "Informacion",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        Ticket ticket = colaTickets.peek();

        IniciarAtencionDelSiguienteTicket form = new IniciarAtencionDelSiguienteTicket(
                ticket.getNombreCliente(),
                ticket.getAsunto(),
                ticket.getPrioridad(),
                ticket.getEstado()
        );

        form.mostrar(vista.getPanel() != null ?
                (JFrame) SwingUtilities.getWindowAncestor(vista.getPanel()) : null);

        if (form.isAtencionIniciada()) {
            colaTickets.desencolar();
            ticket.setEstado("En atención");
            listaAtencion.agregar(ticket);

            JOptionPane.showMessageDialog(
                    vista.getPanel(),
                    "Ticket en atencion:\nCliente: " + ticket.getNombreCliente() +
                            "\nAsunto: " + ticket.getAsunto() +
                            "\nPrioridad: " + ticket.getPrioridad(),
                    "Ticket en Atención",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void handleConsultarTicketPendienteClick() {
        List<Ticket> pendientes = colaTickets.getTodos();
        StringBuilder sb = new StringBuilder();

        if (pendientes.isEmpty()) {
            sb.append("No hay tickets pendientes de atencion.");
        } else {
            for (Ticket t : pendientes) {
                sb.append("Cliente: ").append(t.getNombreCliente())
                        .append("\nAsunto: ").append(t.getAsunto())
                        .append("\nPrioridad: ").append(t.getPrioridad())
                        .append("\n\n");
            }
        }

        JOptionPane.showMessageDialog(
                vista.getPanel(),
                sb.toString(),
                "Tickets Pendientes",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void handleConsultarHistorialClick() {
        StringBuilder sb = new StringBuilder();
        if (tickets.isEmpty()) {
            sb.append("No se han registrado tickets.");
        } else {
            for (int i = 0; i < tickets.size(); i++) {
                Ticket t = tickets.get(i);
                sb.append(i + 1).append(". ").append(t.getNombreCliente())
                        .append(" - ").append(t.getAsunto())
                        .append(" [").append(t.getPrioridad()).append("]")
                        .append(" - ").append(t.getEstado())
                        .append("\n");
            }
        }
        JOptionPane.showMessageDialog(
                vista.getPanel(),
                sb.toString(),
                "Historial de Tickets",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
