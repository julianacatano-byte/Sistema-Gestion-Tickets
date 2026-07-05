package Vistas;

import Controladores.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginForm {
    private JPanel panel1;
    private JButton clienteButton;
    private JButton administradorButton;
    private final LoginController controller;
    private JFrame frame;

    public LoginForm(LoginController controller) {
        this.controller = controller;
        inicializarComponentes();
        configurarEventos();
    }

    private void inicializarComponentes() {
        panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titulo = new JLabel("Seleccione tipo de usuario");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 30, 10);
        panel1.add(titulo, gbc);

        administradorButton = new JButton("Administrador");
        administradorButton.setPreferredSize(new Dimension(180, 40));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 20, 10, 10);
        panel1.add(administradorButton, gbc);

        clienteButton = new JButton("Cliente");
        clienteButton.setPreferredSize(new Dimension(180, 40));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 20);
        panel1.add(clienteButton, gbc);
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
