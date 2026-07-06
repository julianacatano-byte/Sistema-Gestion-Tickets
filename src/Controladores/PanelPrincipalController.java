package Controladores;

import Modelos.Ticket;
import Vistas.PanelPrincipal;

import javax.swing.*;
import java.util.List;

public class PanelPrincipalController {

    private final List<Ticket> tickets;
    private PanelPrincipal vista;

    public PanelPrincipalController(List<Ticket> tickets) {
        this.tickets = tickets;
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

    private void handleAtenderTicketClick() {

        for (Ticket t : tickets) {

            if ("Nuevo".equals(t.getEstado())) {

                t.setEstado("En atención");

                JOptionPane.showMessageDialog(
                        vista.getPanel(),
                        "Ticket atendido:\n\n" +
                                "Cliente: " + t.getNombreCliente() +
                                "\nAsunto: " + t.getAsunto() +
                                "\nEstado: " + t.getEstado(),
                        "Ticket Atendido",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        }

        JOptionPane.showMessageDialog(
                vista.getPanel(),
                "No hay tickets nuevos por atender.",
                "Información",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void handleConsultarTicketPendienteClick() {

        StringBuilder sb = new StringBuilder();
        boolean hayPendientes = false;

        for (Ticket t : tickets) {

            if ("Nuevo".equals(t.getEstado())) {

                hayPendientes = true;

                sb.append("Cliente: ").append(t.getNombreCliente())
                        .append("\nAsunto: ").append(t.getAsunto())
                        .append("\nPrioridad: ").append(t.getPrioridad())
                        .append("\nEstado: ").append(t.getEstado())
                        .append("\n\n");
            }
        }

        if (!hayPendientes) {
            sb.append("No hay tickets pendientes.");
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

                sb.append("Ticket ").append(i + 1).append("\n")
                        .append("Cliente: ").append(t.getNombreCliente()).append("\n")
                        .append("Asunto: ").append(t.getAsunto()).append("\n")
                        .append("Prioridad: ").append(t.getPrioridad()).append("\n")
                        .append("Estado: ").append(t.getEstado()).append("\n\n");
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