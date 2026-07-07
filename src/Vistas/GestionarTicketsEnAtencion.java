package Vistas;

import javax.swing.*;
import java.awt.*;

public class GestionarTicketsEnAtencion {
    private JButton buscarTicketButton;
    private JButton cambiarPrioridadButton;
    private JButton eliminarTicketButton;
    private JPanel panel1;

    public GestionarTicketsEnAtencion() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 15, 10, 15);

        JLabel lblTitulo = new JLabel("Gestionar tickets en atencion");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel1.add(lblTitulo, gbc);

        JLabel lblOpcion = new JLabel("Escoja una opcion:");
        lblOpcion.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel1.add(lblOpcion, gbc);

        buscarTicketButton = new JButton("Buscar ticket");
        buscarTicketButton.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel1.add(buscarTicketButton, gbc);

        eliminarTicketButton = new JButton("Eliminar ticket");
        eliminarTicketButton.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel1.add(eliminarTicketButton, gbc);

        cambiarPrioridadButton = new JButton("Cambiar prioridad");
        cambiarPrioridadButton.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel1.add(cambiarPrioridadButton, gbc);
    }

    public JPanel getPanel() {
        return panel1;
    }

    public void mostrar() {
        JFrame frame = new JFrame("Gestionar Tickets en Atencion");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
