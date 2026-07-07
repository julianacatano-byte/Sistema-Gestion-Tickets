import Controladores.*;
import Modelos.Administrador;
import Modelos.ColaTickets;
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

            // Cola de tickets
            ColaTickets colaTickets = new ColaTickets();

            // Panel principal
            PanelPrincipalController panelPrincipalController =
                    new PanelPrincipalController(tickets, colaTickets);

            // Login administrador
            AdminLoginController adminLoginController =
                    new AdminLoginController(admins, panelPrincipalController);

            // Cliente
            ClienteController clienteController =
                    new ClienteController(tickets, colaTickets);

            // Login
            LoginController loginController =
                    new LoginController(adminLoginController, clienteController);

            LoginForm loginForm = new LoginForm(loginController);

            adminLoginController.setVentanaAnterior(loginForm);
            clienteController.setVentanaAnterior(loginForm);

            loginForm.mostrar();
        });
    }
}
