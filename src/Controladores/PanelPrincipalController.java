package Controladores;

import Estructuras.ColaTickets;
import Estructuras.ListaDobleEnlazada;
import Modelos.Estado;
import Modelos.Ticket;
import Vistas.BuscarTicketsEnAtencion;
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

    public void onBuscarTicketsEnAtencionClick() {
        BuscarTicketsEnAtencion buscar = new BuscarTicketsEnAtencion(idStr -> {
            try {
                int id = Integer.parseInt(idStr.trim());
                Ticket ticket = listaAtencion.buscar(id);

                if (ticket != null) {
                    return "ID: " + ticket.getId() +
                            "\nCliente: " + ticket.getNombreCliente() +
                            "\nAsunto: " + ticket.getAsunto() +
                            "\nPrioridad: " + ticket.getPrioridadDisplay() +
                            "\nEstado: " + ticket.getEstadoDisplay() +
                            "\n------------------------------";
                }

                return "No se encontró un ticket en atención con el ID " + id + ".";

            } catch (NumberFormatException e) {
                return "El ID debe ser un número válido.";
            }
        });

        buscar.mostrar();
    }

    private void handleAtenderTicketClick() {

        if (colaTickets.estaVacia()) {
            JOptionPane.showMessageDialog(
                    vista.getPanel(),
                    "No hay tickets pendientes por atender.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        Ticket ticket = colaTickets.peek();

        IniciarAtencionDelSiguienteTicket form = new IniciarAtencionDelSiguienteTicket(
                ticket.getNombreCliente(),
                ticket.getAsunto(),
                ticket.getPrioridadDisplay(),
                ticket.getEstadoDisplay()
        );

        form.mostrar(vista.getPanel() != null ?
                (JFrame) SwingUtilities.getWindowAncestor(vista.getPanel()) : null);

        if (form.isAtencionIniciada()) {

            colaTickets.desencolar();

            // Guarda el cambio de estado en la pila
            ticket.cambiarEstado(Estado.EN_ATENCION);

            listaAtencion.agregar(ticket);

            JOptionPane.showMessageDialog(
                    vista.getPanel(),
                    "ID: " + ticket.getId() +
                            "\nCliente: " + ticket.getNombreCliente() +
                            "\nAsunto: " + ticket.getAsunto() +
                            "\nPrioridad: " + ticket.getPrioridadDisplay() +
                            "\nEstado: " + ticket.getEstadoDisplay() +
                            "\n------------------------------",
                    "Ticket en Atención",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void handleConsultarTicketPendienteClick() {

        List<Ticket> pendientes = colaTickets.getTodos();
        StringBuilder sb = new StringBuilder();

        if (pendientes.isEmpty()) {

            sb.append("No hay tickets pendientes de atención.");

        } else {

            for (Ticket t : pendientes) {

                sb.append("ID: ").append(t.getId())
                        .append("\nCliente: ").append(t.getNombreCliente())
                        .append("\nAsunto: ").append(t.getAsunto())
                        .append("\nPrioridad: ").append(t.getPrioridadDisplay())
                        .append("\nEstado: ").append(t.getEstadoDisplay())
                        .append("\n------------------------------\n");
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

        for (Ticket t : tickets) {

            sb.append("ID: ").append(t.getId())
                    .append("\nCliente: ").append(t.getNombreCliente())
                    .append("\nAsunto: ").append(t.getAsunto())
                    .append("\nPrioridad: ").append(t.getPrioridadDisplay())
                    .append("\nEstado: ").append(t.getEstadoDisplay())
                    .append("\n------------------------------\n");
        }

        if (sb.length() == 0) {
            sb.append("No se han registrado tickets.");
        }

        JOptionPane.showMessageDialog(
                vista.getPanel(),
                sb.toString(),
                "Historial de Tickets",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void handleMostrarInicioFin() {

        StringBuilder sb = new StringBuilder();

        for (Ticket t : listaAtencion.recorrerInicioFin()) {

            sb.append("ID: ").append(t.getId())
                    .append("\nCliente: ").append(t.getNombreCliente())
                    .append("\nAsunto: ").append(t.getAsunto())
                    .append("\nPrioridad: ").append(t.getPrioridadDisplay())
                    .append("\nEstado: ").append(t.getEstadoDisplay())
                    .append("\n------------------------------\n");
        }

        if (sb.length() == 0) {
            sb.append("No hay tickets en atención.");
        }

        JOptionPane.showMessageDialog(
                vista.getPanel(),
                sb.toString(),
                "Tickets en Atención (Inicio → Fin)",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void handleMostrarFinInicio() {

        StringBuilder sb = new StringBuilder();

        for (Ticket t : listaAtencion.recorrerFinInicio()) {

            sb.append("ID: ").append(t.getId())
                    .append("\nCliente: ").append(t.getNombreCliente())
                    .append("\nAsunto: ").append(t.getAsunto())
                    .append("\nPrioridad: ").append(t.getPrioridadDisplay())
                    .append("\nEstado: ").append(t.getEstadoDisplay())
                    .append("\n------------------------------\n");
        }

        if (sb.length() == 0) {
            sb.append("No hay tickets en atención.");
        }

        JOptionPane.showMessageDialog(
                vista.getPanel(),
                sb.toString(),
                "Tickets en Atención (Fin → Inicio)",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void onMostrarInicioFin() {
        handleMostrarInicioFin();
    }

    public void onMostrarFinInicio() {
        handleMostrarFinInicio();
    }
}