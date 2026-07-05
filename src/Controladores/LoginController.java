package Controladores;

public class LoginController {
    private final AdminLoginController adminLoginController;
    private final ClienteController clienteController;

    public LoginController(AdminLoginController adminLoginController,
                           ClienteController clienteController) {
        this.adminLoginController = adminLoginController;
        this.clienteController = clienteController;
    }

    public void onAdministradorClick() {
        handleAdministradorClick();
    }

    public void onClienteClick() {
        handleClienteClick();
    }

    private void handleAdministradorClick() {
        adminLoginController.mostrarLogin();
    }

    private void handleClienteClick() {
        clienteController.mostrarFormulario();
    }
}
