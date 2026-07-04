package Controladores;

import Modelos.Administrador;
import Modelos.Cliente;
import Modelos.Usuario;

public class LoginController {
    private static final String ADMIN_PASSWORD = "admin123";
    private Usuario usuarioActual;

    public Usuario iniciarSesionCliente() {
        usuarioActual = new Cliente("Invitado", "cliente@mail.com");
        return usuarioActual;
    }

    public Usuario iniciarSesionAdmin(String username, String password) {
        Administrador admin = new Administrador(username, ADMIN_PASSWORD);
        if (admin.validarPassword(password)) {
            usuarioActual = admin;
            return usuarioActual;
        }
        return null;
    }

    public boolean esAdmin() {
        return usuarioActual != null && usuarioActual.esAdmin();
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
}
