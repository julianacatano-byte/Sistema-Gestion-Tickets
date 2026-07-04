package Modelos;

public class Cliente extends Usuario {
    private String email;

    public Cliente(String username, String email) {
        super(username);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return "CLIENTE";
    }
}
