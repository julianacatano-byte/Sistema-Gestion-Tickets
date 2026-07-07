package Vistas;

import Controladores.LoginController;

import javax.swing.*;

public class LoginForm {
    private JPanel panel1;
    private JButton clienteButton;
    private JButton administradorButton;
    private final LoginController controller;
    private JFrame frame;

    public LoginForm(LoginController controller) {
        this.controller = controller;
        configurarEventos();
    }

    private void configurarEventos() {
        administradorButton.addActionListener(e -> {
            ocultar();
            controller.onAdministradorClick();
        });
        clienteButton.addActionListener(e -> {
            ocultar();
            controller.onClienteClick();
        });
    }

    public void ocultar() {
        if (frame != null) {
            frame.setVisible(false);
        }
    }

    public void mostrar() {
        if (frame == null) {
            frame = new JFrame("Sistema de Gesti\u00f3n de Tickets");
            frame.setContentPane(panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setLocationRelativeTo(null);
        }
        frame.setVisible(true);
    }
}
