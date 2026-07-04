package Modelos;

public class Usuario {
    private String username;

    public Usuario(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean esAdmin() {
        return false;
    }
}
