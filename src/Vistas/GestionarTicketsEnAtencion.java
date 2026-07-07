package Vistas;

import Estructuras.ListaDobleEnlazada;
import Modelos.Ticket;

import javax.swing.*;

public class GestionarTicketsEnAtencion {
    private JPanel panel1;
    private JTextField txtBuscarId;
    private JLabel lblResultado;
    private JButton buscarTicketButton;
    private JButton cambiarPrioridadButton;
    private JButton eliminarTicketButton;

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
                        ticketActual.getId(), ticketActual.getNombreCliente(),
                        ticketActual.getAsunto(), ticketActual.getPrioridadDisplay(),
                        ticketActual.getEstadoDisplay()
                ));
            } else {
                lblResultado.setText("No se encontro un ticket con ID " + id + " en atencion.");
                ticketActual = null;
            }
        } catch (NumberFormatException e) {
            lblResultado.setText("El ID debe ser un numero valido.");
            ticketActual = null;
        }
    }

    public JPanel getPanel() {
        return panel1;
    }

    public void mostrar() {
        frame = new JFrame("Gestionar Tickets en Atencion");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(520, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
