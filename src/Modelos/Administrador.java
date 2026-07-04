package Modelos;

public class Administrador extends Usuario {
    private String password;

    public Administrador(String username, String password) {
        super(username);
        this.password = password;
    }

    @Override
    public boolean esAdmin() {
        return true;
    }

    public boolean validarPassword(String password) {
        return this.password.equals(password);
    }
}
