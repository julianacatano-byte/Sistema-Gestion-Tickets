package Vistas;

import Controladores.LoginController;
import Modelos.Usuario;

import javax.swing.*;
import java.awt.*;

public class VistaLogin extends JFrame {
    private final LoginController loginController;

    public VistaLogin() {
        loginController = new LoginController();
        initUI();
    }

    private void initUI() {
        setTitle("Sistema de Gesti\u00f3n de Tickets");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        JLabel lblTitulo = new JLabel("Sistema de Gesti\u00f3n de Tickets");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitulo, gbc);

        JLabel lblSeleccione = new JLabel("Seleccione su tipo de inicio de sesi\u00f3n:");
        add(lblSeleccione, gbc);

        JButton btnCliente = new JButton("Iniciar como Cliente");
        btnCliente.addActionListener(e -> iniciarComoCliente());
        add(btnCliente, gbc);

        JButton btnAdmin = new JButton("Iniciar como Administrador");
        btnAdmin.addActionListener(e -> iniciarComoAdmin());
        add(btnAdmin, gbc);
    }

    private void iniciarComoCliente() {
        loginController.iniciarSesionCliente();
        abrirMenuPrincipal();
    }

    private void iniciarComoAdmin() {
        JTextField txtUser = new JTextField(15);
        JPasswordField txtPass = new JPasswordField(15);
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("Usuario:"));
        panel.add(txtUser);
        panel.add(new JLabel("Contrase\u00f1a:"));
        panel.add(txtPass);

        int result = JOptionPane.showConfirmDialog(this, panel,
                "Credenciales de Administrador",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String username = txtUser.getText().trim();
            String password = new String(txtPass.getPassword());

            Usuario admin = loginController.iniciarSesionAdmin(username, password);
            if (admin != null) {
                abrirMenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Contrase\u00f1a incorrecta",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void abrirMenuPrincipal() {
        new VistaMenuPrincipal(loginController, this).setVisible(true);
        setVisible(false);
    }
}
