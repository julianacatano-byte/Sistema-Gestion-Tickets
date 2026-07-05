package Modelos;

public class Ticket {
    private String nombreCliente;
    private String asunto;
    private String prioridad;
    private String estado;

    public Ticket(String nombreCliente, String asunto, String prioridad) {
        this.nombreCliente = nombreCliente;
        this.asunto = asunto;
        this.prioridad = prioridad;
        this.estado = "PENDIENTE";
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
