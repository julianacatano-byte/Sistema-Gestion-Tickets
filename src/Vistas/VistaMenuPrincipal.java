package Vistas;

import Controladores.LoginController;
import Modelos.Administrador;
import Modelos.Cliente;
import Modelos.Usuario;

import javax.swing.*;
import java.awt.*;

public class VistaMenuPrincipal extends JFrame {
    private final LoginController loginController;
    private final VistaLogin vistaLogin;

    public VistaMenuPrincipal(LoginController loginController, VistaLogin vistaLogin) {
        this.loginController = loginController;
        this.vistaLogin = vistaLogin;
        initUI();
    }

    private void initUI() {
        Usuario usuario = loginController.getUsuarioActual();
        String rol = usuario instanceof Administrador ? "ADMINISTRADOR"
                : usuario instanceof Cliente ? "CLIENTE" : "DESCONOCIDO";

        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblBienvenida = new JLabel(
                "Bienvenido " + usuario.getUsername() + " - Rol: " + rol,
                SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblBienvenida, BorderLayout.CENTER);

        JButton btnCerrar = new JButton("Cerrar Sesion");
        btnCerrar.addActionListener(e -> cerrarSesion());
        add(btnCerrar, BorderLayout.SOUTH);
    }

    private void cerrarSesion() {
        vistaLogin.setVisible(true);
        dispose();
    }
}
