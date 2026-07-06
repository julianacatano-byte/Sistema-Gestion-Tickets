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
            if ("PENDIENTE".equals(t.getEstado())) {
                t.setEstado("ATENDIDO");
                JOptionPane.showMessageDialog(
                        vista.getPanel(),
                        "Ticket atendido:Cliente: " + t.getNombreCliente() +
                                "Asunto: " + t.getAsunto(),
                        "Ticket Atendido",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        }
        JOptionPane.showMessageDialog(
                vista.getPanel(),
                "No hay tickets pendientes por atender.",
                "Informacion",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void handleConsultarTicketPendienteClick() {
        StringBuilder sb = new StringBuilder();
        boolean hayPendientes = false;
        for (Ticket t : tickets) {
            if ("PENDIENTE".equals(t.getEstado())) {
                hayPendientes = true;
                sb.append("Cliente: ").append(t.getNombreCliente())
                        .append("Asunto: ").append(t.getAsunto())
                        .append("Prioridad: ").append(t.getPrioridad())
                        .append(" ");
            }
        }
        if (!hayPendientes) {
            sb.append("No hay tickets pendientes de atencion.");
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
