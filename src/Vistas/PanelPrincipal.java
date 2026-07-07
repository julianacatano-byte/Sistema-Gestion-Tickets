package Vistas;

import Controladores.PanelPrincipalController;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PanelPrincipal {
    private JPanel panel1;
    private JButton atenderTicketButton;
    private JButton consultarTicketPendienteDeButton;
    private JButton consultarHistorialDeEstadoButton;
    private JButton gestionarTicketsEnAtencionButton;
    private JButton buscarTicketsEnAtencionButton;
    private JButton mostrarTicketInicioFinButton;
    private JButton mostrarTicketFinInicioButton;
    private final PanelPrincipalController controller;

    public PanelPrincipal(PanelPrincipalController controller) {
        this.controller = controller;
        configurarEventos();
    }

    private void configurarEventos() {
        atenderTicketButton.addActionListener(e -> controller.onAtenderTicketClick());
        consultarTicketPendienteDeButton.addActionListener(e -> controller.onConsultarTicketPendienteClick());
        consultarHistorialDeEstadoButton.addActionListener(e -> controller.onConsultarHistorialClick());
        gestionarTicketsEnAtencionButton.addActionListener(e -> controller.onGestionarTicketsEnAtencionClick());
        buscarTicketsEnAtencionButton.addActionListener(e -> controller.onBuscarTicketsEnAtencionClick());
        mostrarTicketInicioFinButton.addActionListener(e -> controller.onMostrarInicioFin());
        mostrarTicketFinInicioButton.addActionListener(e -> controller.onMostrarFinInicio());
       

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
