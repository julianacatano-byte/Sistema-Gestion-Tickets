package Vistas;

import Estructuras.ListaDobleEnlazada;
import Modelos.Ticket;

import javax.swing.*;
import java.awt.*;

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
        inicializarComponentes();
        configurarEventos();
    }

    private void inicializarComponentes() {
        panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 15, 8, 15);

        JLabel lblTitulo = new JLabel("Gestionar tickets en atencion");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel1.add(lblTitulo, gbc);

        JLabel lblId = new JLabel("ID del ticket:");
        lblId.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(lblId, gbc);

        txtBuscarId = new JTextField(10);
        txtBuscarId.setPreferredSize(new Dimension(150, 28));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel1.add(txtBuscarId, gbc);

        buscarTicketButton = new JButton("Buscar ticket");
        buscarTicketButton.setPreferredSize(new Dimension(200, 35));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel1.add(buscarTicketButton, gbc);

        lblResultado = new JLabel(" ");
        lblResultado.setFont(new Font("Arial", Font.PLAIN, 13));
        gbc.gridy = 3;
        panel1.add(lblResultado, gbc);

        eliminarTicketButton = new JButton("Eliminar ticket");
        eliminarTicketButton.setPreferredSize(new Dimension(200, 40));
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel1.add(eliminarTicketButton, gbc);

        cambiarPrioridadButton = new JButton("Cambiar prioridad");
        cambiarPrioridadButton.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel1.add(cambiarPrioridadButton, gbc);
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
                        ticketActual.getAsunto(), ticketActual.getPrioridad(),
                        ticketActual.getEstado()
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
