package Controladores;

import Modelos.Administrador;
import Vistas.AdminLoginForm;
import Vistas.LoginForm;

import javax.swing.*;
import java.util.List;

public class AdminLoginController {
    private final List<Administrador> admins;
    private final PanelPrincipalController panelPrincipalController;
    private AdminLoginForm vista;
    private LoginForm ventanaAnterior;

    public AdminLoginController(List<Administrador> admins,
                                PanelPrincipalController panelPrincipalController) {
        this.admins = admins;
        this.panelPrincipalController = panelPrincipalController;
    }

    public void setVentanaAnterior(LoginForm ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
    }

    public void mostrarLogin() {
        this.vista = new AdminLoginForm(this, ventanaAnterior);
        this.vista.mostrar();
    }

    public void onConfirmarClick() {
        handleConfirmarClick();
    }

    private void handleConfirmarClick() {
        if (!validarCampos()) return;

        String username = vista.getUsuarioField().getText().trim();
        String password = new String(vista.getPasswordField().getPassword());

        if (autenticar(username, password)) {
            vista.marcarLoginExitoso();
            mostrarPanelPrincipal();
        } else {
            mostrarError("Usuario o contrase\u00f1a incorrectos");
        }
    }

    private boolean validarCampos() {
        if (vista.getUsuarioField().getText().trim().isEmpty()) {
            mostrarError("Debe ingresar un usuario");
            return false;
        }
        if (vista.getPasswordField().getPassword().length == 0) {
            mostrarError("Debe ingresar una contrase\u00f1a");
            return false;
        }
        return true;
    }

    private boolean autenticar(String username, String password) {
        for (Administrador admin : admins) {
            if (admin.getUsername().equals(username) && admin.validarPassword(password)) {
                return true;
            }
        }
        return false;
    }

    private void mostrarPanelPrincipal() {
        vista.cerrar();
        panelPrincipalController.mostrarPanel();
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
                vista.getPanel(),
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
