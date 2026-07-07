package Vistas;

import Estructuras.ListaDobleEnlazada;
import Modelos.Estado;
import Modelos.Prioridad;
import Modelos.Ticket;

import javax.swing.*;

public class GestionarTicketsEnAtencion {

    private JPanel panel1;
    private JTextField txtBuscarId;
    private JLabel lblResultado;
    private JButton buscarTicketButton;
    private JButton cambiarPrioridadButton;
    private JButton eliminarTicketButton;
    private JButton cambiarEstadoButton;
    private JButton mostrarHistorialButton;
    private JButton deshacerEstadoButton;
    private JButton cerrarTicketButton;

    private final ListaDobleEnlazada lista;
    private Ticket ticketActual;
    private JFrame frame;

    public GestionarTicketsEnAtencion(ListaDobleEnlazada lista) {
        this.lista = lista;
        this.ticketActual = null;
        configurarEventos();
    }

    private void configurarEventos() {
        buscarTicketButton.addActionListener(e -> handleBuscar());
        cambiarPrioridadButton.addActionListener(e -> handleCambiarPrioridad());
        cambiarEstadoButton.addActionListener(e -> handleCambiarEstado());
        mostrarHistorialButton.addActionListener(e -> handleMostrarHistorial());
        deshacerEstadoButton.addActionListener(e -> handleDeshacerEstado());
        cerrarTicketButton.addActionListener(e -> handleCerrarTicket());
        eliminarTicketButton.addActionListener(e -> handleEliminarTicket());
    }

    private void handleBuscar() {

        String idTexto = txtBuscarId.getText().trim();

        if (idTexto.isEmpty()) {
            lblResultado.setText("Ingrese un ID de ticket.");
            ticketActual = null;
            return;
        }

        try {

            int id = Integer.parseInt(idTexto);

            ticketActual = lista.buscar(id);

            if (ticketActual != null) {

                lblResultado.setText(String.format(
                        "ID: %d | Cliente: %s | Asunto: %s | Prioridad: %s | Estado: %s",
                        ticketActual.getId(),
                        ticketActual.getNombreCliente(),
                        ticketActual.getAsunto(),
                        ticketActual.getPrioridadDisplay(),
                        ticketActual.getEstadoDisplay()));

            } else {

                lblResultado.setText("No se encontró el ticket.");
                ticketActual = null;

            }

        } catch (NumberFormatException e) {

            lblResultado.setText("El ID debe ser un número.");

        }
    }

    private void handleCambiarPrioridad() {

        if (ticketActual == null) {

            JOptionPane.showMessageDialog(frame,
                    "Primero debe buscar un ticket.");

            return;
        }

        Prioridad nueva = (Prioridad) JOptionPane.showInputDialog(
                frame,
                "Seleccione la prioridad",
                "Cambiar Prioridad",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Prioridad.values(),
                ticketActual.getPrioridad());

        if (nueva != null) {

            lista.cambiarPrioridad(ticketActual, nueva);

            lblResultado.setText(String.format(
                    "ID: %d | Cliente: %s | Asunto: %s | Prioridad: %s | Estado: %s",
                    ticketActual.getId(),
                    ticketActual.getNombreCliente(),
                    ticketActual.getAsunto(),
                    ticketActual.getPrioridadDisplay(),
                    ticketActual.getEstadoDisplay()));

        }
    }

    private void handleCambiarEstado() {

        if (ticketActual == null) {

            JOptionPane.showMessageDialog(frame,
                    "Primero debe buscar un ticket.");

            return;
        }

        Estado nuevoEstado = (Estado) JOptionPane.showInputDialog(
                frame,
                "Seleccione el estado",
                "Cambiar Estado",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Estado.values(),
                ticketActual.getEstado());

        if (nuevoEstado != null) {

            ticketActual.cambiarEstado(nuevoEstado);

            lblResultado.setText(String.format(
                    "ID: %d | Cliente: %s | Asunto: %s | Prioridad: %s | Estado: %s",
                    ticketActual.getId(),
                    ticketActual.getNombreCliente(),
                    ticketActual.getAsunto(),
                    ticketActual.getPrioridadDisplay(),
                    ticketActual.getEstadoDisplay()));

        }
    }
    private void handleMostrarHistorial() {

        if (ticketActual == null) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Primero debe buscar un ticket."
            );
            return;
        }

        StringBuilder historial = new StringBuilder();
        historial.append("Historial de estados del Ticket ")
                .append(ticketActual.getId())
                .append("\n\n");

        for (Estado estado : ticketActual.getHistorialEstados().getTodos()) {
            historial.append("- ")
                    .append(estado.getDisplayName())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(
                frame,
                historial.toString(),
                "Historial de Estados",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    private void handleDeshacerEstado() {

        if (ticketActual == null) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Primero debe buscar un ticket."
            );
            return;
        }

        ticketActual.deshacerEstado();

        lblResultado.setText(String.format(
                "ID: %d | Cliente: %s | Asunto: %s | Prioridad: %s | Estado: %s",
                ticketActual.getId(),
                ticketActual.getNombreCliente(),
                ticketActual.getAsunto(),
                ticketActual.getPrioridadDisplay(),
                ticketActual.getEstadoDisplay()
        ));

        JOptionPane.showMessageDialog(
                frame,
                "Se deshizo el último cambio de estado."
        );
    }

    public JPanel getPanel() {
        return panel1;
    }
    private void handleCerrarTicket() {

        if (ticketActual == null) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Primero debe buscar un ticket."
            );
            return;
        }

        ticketActual.cambiarEstado(Estado.RESUELTO);

        lista.eliminar(ticketActual);

        JOptionPane.showMessageDialog(
                frame,
                "El ticket fue cerrado correctamente."
        );

        lblResultado.setText("");

        ticketActual = null;
    }
    private void handleEliminarTicket() {

        if (ticketActual == null) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Primero debe buscar un ticket."
            );
            return;
        }

        if (lista.eliminar(ticketActual)) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Ticket eliminado correctamente."
            );

            lblResultado.setText("");

            ticketActual = null;

        } else {

            JOptionPane.showMessageDialog(
                    frame,
                    "No fue posible eliminar el ticket."
            );
        }
    }

    public void mostrar() {
        frame = new JFrame("Gestionar Tickets en Atención");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(550, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}