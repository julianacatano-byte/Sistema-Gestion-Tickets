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

        JLabel lblTitulo = new JLabel("Panel de administrador");
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

        atenderTicketButton = new JButton("Atender ticket");
        atenderTicketButton.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(atenderTicketButton, gbc);

        consultarTicketPendienteDeButton = new JButton("Consultar ticket pendiente de atencion");
        consultarTicketPendienteDeButton.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel1.add(consultarTicketPendienteDeButton, gbc);

        consultarHistorialDeEstadoButton = new JButton("Consultar historial de estado");
        consultarHistorialDeEstadoButton.setPreferredSize(new Dimension(220, 40));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel1.add(consultarHistorialDeEstadoButton, gbc);

        gestionarTicketsEnAtencionButton = new JButton("Gestionar tickets en Atencion");
        gestionarTicketsEnAtencionButton.setPreferredSize(new Dimension(220, 40));
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel1.add(gestionarTicketsEnAtencionButton, gbc);
    }

    private void configurarEventos() {
        atenderTicketButton.addActionListener(e -> controller.onAtenderTicketClick());
        consultarTicketPendienteDeButton.addActionListener(e -> controller.onConsultarTicketPendienteClick());
        consultarHistorialDeEstadoButton.addActionListener(e -> controller.onConsultarHistorialClick());
        gestionarTicketsEnAtencionButton.addActionListener(e -> controller.onGestionarTicketsEnAtencionClick());
    }

    public JPanel getPanel() {
        return panel1;
    }

    public void mostrar() {
        JFrame frame = new JFrame("Panel de Administracion");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(520, 300);
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
