import Controladores.*;
import Modelos.Administrador;
import Modelos.Ticket;
import Vistas.LoginForm;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<Administrador> admins = new ArrayList<>();
            admins.add(new Administrador("admin", "1234"));
            admins.add(new Administrador("root", "root123"));

            List<Ticket> tickets = new ArrayList<>();

            PanelPrincipalController panelPrincipalController = new PanelPrincipalController(tickets);
            AdminLoginController adminLoginController = new AdminLoginController(admins, panelPrincipalController);
            ClienteController clienteController = new ClienteController(tickets);
            LoginController loginController = new LoginController(adminLoginController, clienteController);

            LoginForm loginForm = new LoginForm(loginController);
            adminLoginController.setVentanaAnterior(loginForm);
            clienteController.setVentanaAnterior(loginForm);

            loginForm.mostrar();
        });
    }
}
