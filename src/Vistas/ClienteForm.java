package Vistas;

import Controladores.ClienteController;
import Modelos.Prioridad;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClienteForm {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox<Prioridad> comboBox1;
    private JButton confirmarButton;
    private final ClienteController controller;
    private final LoginForm ventanaAnterior;
    private JFrame frame;
    private boolean ticketCreado;

    public ClienteForm(ClienteController controller, LoginForm ventanaAnterior) {
        this.controller = controller;
        this.ventanaAnterior = ventanaAnterior;
        comboBox1.setModel(new DefaultComboBoxModel<>(Prioridad.values()));
        configurarEventos();
    }

    private void configurarEventos() {
        confirmarButton.addActionListener(e -> controller.onConfirmarClick());
    }

    public void marcarTicketCreado() {
        this.ticketCreado = true;
    }

    public JTextField getNombreField() {
        return textField1;
    }

    public JTextField getAsuntoField() {
        return textField2;
    }

    public JComboBox<Prioridad> getPrioridadCombo() {
        return comboBox1;
    }

    public JPanel getPanel() {
        return panel1;
    }

    public void mostrar() {
        frame = new JFrame("Registro de Ticket");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 420);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (!ticketCreado && ventanaAnterior != null) {
                    ventanaAnterior.mostrar();
                }
            }
        });
        frame.setVisible(true);
    }

    public void cerrar() {
        if (frame != null) {
            frame.dispose();
        }
    }
}
