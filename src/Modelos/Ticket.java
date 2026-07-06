package Modelos;

public class Ticket {
    private static int contador = 0;
    private int id;
    private String nombreCliente;
    private String asunto;
    private String prioridad;
    private String estado;

    public Ticket(String nombreCliente, String asunto, String prioridad) {
        this.id = ++contador;
        this.nombreCliente = nombreCliente;
        this.asunto = asunto;
        this.prioridad = prioridad;
        this.estado = "PENDIENTE";
    }

    public int getId() {
        return id;
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

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
