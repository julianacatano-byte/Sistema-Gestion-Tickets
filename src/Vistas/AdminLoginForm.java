package Vistas;

import Controladores.AdminLoginController;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminLoginForm {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton confirmarButton;
    private final AdminLoginController controller;
    private final LoginForm ventanaAnterior;
    private JFrame frame;
    private boolean loginExitoso;

    public AdminLoginForm(AdminLoginController controller, LoginForm ventanaAnterior) {
        this.controller = controller;
        this.ventanaAnterior = ventanaAnterior;
        configurarEventos();
    }

    private void configurarEventos() {
        confirmarButton.addActionListener(e -> controller.onConfirmarClick());
    }

    public void marcarLoginExitoso() {
        this.loginExitoso = true;
    }

    public JTextField getUsuarioField() {
        return textField1;
    }

    public JPasswordField getPasswordField() {
        return passwordField1;
    }

    public JPanel getPanel() {
        return panel1;
    }

    public void mostrar() {
        frame = new JFrame("Inicio de Sesi\u00f3n - Administrador");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (!loginExitoso && ventanaAnterior != null) {
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
