package Vistas;

import Controladores.PanelPrincipalController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PanelPrincipal {

    private JPanel panel1;
    private JButton atenderTicketButton;
    private JButton consultarTicketPendienteDeButton;
    private JButton consultarHistorialDeEstadoButton;
    private JButton gestionarTicketsEnAtencionButton;
    private JButton deshacerÚltimoCambioButton;
    private JButton deshacerEstadoButton;

    private final PanelPrincipalController controller;

    public PanelPrincipal(PanelPrincipalController controller) {
        this.controller = controller;
        inicializarComponentes();
        configurarEventos();
    }

    private void inicializarComponentes() {

        panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 15, 10, 15);

        // Título
        JLabel lblTitulo = new JLabel("Panel de administrador");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel1.add(lblTitulo, gbc);

        // Texto
        JLabel lblOpcion = new JLabel("Escoja una opción:");
        lblOpcion.setFont(new Font("Arial", Font.PLAIN, 14));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel1.add(lblOpcion, gbc);

        // Botón Atender
        atenderTicketButton = new JButton("Atender ticket");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel1.add(atenderTicketButton, gbc);

        // Botón Consultar pendientes
        consultarTicketPendienteDeButton =
                new JButton("Consultar tickets pendientes");

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel1.add(consultarTicketPendienteDeButton, gbc);

        // Botón Historial
        consultarHistorialDeEstadoButton =
                new JButton("Consultar historial");

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel1.add(consultarHistorialDeEstadoButton, gbc);

        // Botón Gestionar
        gestionarTicketsEnAtencionButton = new JButton("Gestionar tickets en atención");

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel1.add(gestionarTicketsEnAtencionButton, gbc);

        // Botón Deshacer
        deshacerEstadoButton =
                new JButton("Deshacer último cambio");

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel1.add(deshacerEstadoButton, gbc);
    }

    private void configurarEventos() {

        atenderTicketButton.addActionListener(
                e -> controller.onAtenderTicketClick());

        consultarTicketPendienteDeButton.addActionListener(
                e -> controller.onConsultarTicketPendienteClick());

        consultarHistorialDeEstadoButton.addActionListener(
                e -> controller.onConsultarHistorialClick());

        gestionarTicketsEnAtencionButton.addActionListener(
                e -> controller.onGestionarTicketsClick());

        deshacerEstadoButton.addActionListener(
                e -> controller.onDeshacerEstadoClick());
    }

    public JPanel getPanel() {
        return panel1;
    }

    public void mostrar() {

        JFrame frame = new JFrame("Panel de Administración");

        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(650, 420);
        frame.setLocationRelativeTo(null);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}