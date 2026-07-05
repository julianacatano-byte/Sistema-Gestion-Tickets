package Vistas;

import Controladores.AdminLoginController;

import javax.swing.*;
import java.awt.*;
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
        inicializarComponentes();
        configurarEventos();
    }

    private void inicializarComponentes() {
        panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 20, 8, 20);

        JLabel lblUsuario = new JLabel("Ingrese su usuario:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(lblUsuario, gbc);

        textField1 = new JTextField(20);
        textField1.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(textField1, gbc);

        JLabel lblPassword = new JLabel("Ingrese su contrase\u00f1a:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(lblPassword, gbc);

        passwordField1 = new JPasswordField(20);
        passwordField1.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel1.add(passwordField1, gbc);

        confirmarButton = new JButton("Confirmar");
        confirmarButton.setPreferredSize(new Dimension(150, 35));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(20, 20, 8, 20);
        panel1.add(confirmarButton, gbc);
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
