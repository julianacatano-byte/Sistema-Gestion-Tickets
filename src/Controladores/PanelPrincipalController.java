package Controladores;

import Modelos.Ticket;
import Modelos.ColaTickets;
import Vistas.GestionarTicketsEnAtencion;
import Vistas.PanelPrincipal;

import javax.swing.*;
import java.util.List;

public class PanelPrincipalController {

    private final List<Ticket> tickets;
    private final ColaTickets colaTickets;
    private PanelPrincipal vista;

    public PanelPrincipalController(List<Ticket> tickets, ColaTickets colaTickets) {
        this.tickets = tickets;
        this.colaTickets = colaTickets;
    }

    public void mostrarPanel() {
        vista = new PanelPrincipal(this);
        vista.mostrar();
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

    public void onGestionarTicketsClick() {

        GestionarTicketsEnAtencion gestionar =
                new GestionarTicketsEnAtencion(this);

        JFrame frame = new JFrame("Gestión de Tickets");

        frame.setContentPane(gestionar.getPanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void onDeshacerEstadoClick() {

        String id = JOptionPane.showInputDialog(
                null,
                "Ingrese el ID del ticket:"
        );

        if (id != null && !id.trim().isEmpty()) {
            deshacerEstado(id);
        }
    }

    public void buscarTicket(String id) {

        for (Ticket t : tickets) {

            if (String.valueOf(t.getId()).equals(id)) {

                JOptionPane.showMessageDialog(
                        null,
                        t.toString(),
                        "Ticket encontrado",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "No se encontró el ticket.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public void cambiarEstado(String id) {

        for (Ticket t : tickets) {

            if (String.valueOf(t.getId()).equals(id)) {

                String estado = JOptionPane.showInputDialog(
                        "Nuevo estado:"
                );

                if (estado != null && !estado.trim().isEmpty()) {

                    t.setEstado(estado);

                    JOptionPane.showMessageDialog(
                            null,
                            "Estado actualizado correctamente."
                    );
                }

                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Ticket no encontrado."
        );
    }

    public void cambiarPrioridad(String id) {

        for (Ticket t : tickets) {

            if (String.valueOf(t.getId()).equals(id)) {

                String prioridad = JOptionPane.showInputDialog(
                        "Nueva prioridad:"
                );

                if (prioridad != null && !prioridad.trim().isEmpty()) {

                    t.setPrioridad(prioridad);

                    JOptionPane.showMessageDialog(
                            null,
                            "Prioridad actualizada correctamente."
                    );
                }

                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Ticket no encontrado."
        );
    }    public void mostrarHistorial(String id) {

        for (Ticket t : tickets) {

            if (String.valueOf(t.getId()).equals(id)) {

                JOptionPane.showMessageDialog(
                        null,
                        t.mostrarHistorial(),
                        "Historial del Ticket",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Ticket no encontrado."
        );
    }

    public void deshacerEstado(String id) {

        for (Ticket t : tickets) {

            if (String.valueOf(t.getId()).equals(id)) {

                t.deshacerEstado();

                JOptionPane.showMessageDialog(
                        null,
                        "Último cambio deshecho.\nEstado actual: " + t.getEstado(),
                        "Deshacer Estado",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Ticket no encontrado."
        );
    }

    public void cerrarTicket(String id) {

        for (Ticket t : tickets) {

            if (String.valueOf(t.getId()).equals(id)) {

                t.setEstado("Cerrado");

                JOptionPane.showMessageDialog(
                        null,
                        "El ticket fue cerrado correctamente."
                );
                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Ticket no encontrado."
        );
    }

    public void mostrarTicketsInicioFin() {

        if (tickets.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay tickets.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (Ticket t : tickets) {

            sb.append(t)
                    .append("\n----------------------------\n");
        }

        JOptionPane.showMessageDialog(
                null,
                sb.toString(),
                "Tickets (Inicio → Fin)",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void mostrarTicketsFinInicio() {

        if (tickets.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay tickets.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = tickets.size() - 1; i >= 0; i--) {

            sb.append(tickets.get(i))
                    .append("\n----------------------------\n");
        }

        JOptionPane.showMessageDialog(
                null,
                sb.toString(),
                "Tickets (Fin → Inicio)",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void volverMenuPrincipal() {

        if (vista != null) {
            vista.mostrar();
        }
    }
    private void handleAtenderTicketClick() {

        Ticket ticket = colaTickets.desencolar();

        if (ticket == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "No hay tickets nuevos por atender.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        ticket.setEstado("En atención");

        JOptionPane.showMessageDialog(
                null,
                "Ticket atendido correctamente.\n\n" + ticket,
                "Ticket Atendido",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    private void handleConsultarTicketPendienteClick() {

        StringBuilder sb = new StringBuilder();
        boolean hayPendientes = false;

        for (Ticket t : tickets) {

            if (!"Cerrado".equals(t.getEstado())) {

                hayPendientes = true;

                sb.append(t)
                        .append("\n----------------------------\n");
            }
        }

        if (!hayPendientes) {
            sb.append("No hay tickets pendientes.");
        }

        JOptionPane.showMessageDialog(
                null,
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

            for (Ticket t : tickets) {

                sb.append(t)
                        .append("\nHistorial de estados:\n")
                        .append(t.mostrarHistorial())
                        .append("\n----------------------------\n");
            }
        }

        JOptionPane.showMessageDialog(
                null,
                sb.toString(),
                "Historial de Tickets",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
