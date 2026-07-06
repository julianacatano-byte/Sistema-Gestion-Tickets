package Modelos;

public class Ticket {
    private static int contador = 0;
    private int id;

    private String nombreCliente;
    private String asunto;
    private String prioridad;
    private String estado;

    private Pila historialEstados;

    public Ticket(String nombreCliente, String asunto, String prioridad) {

        this.id = ++contador;
        this.nombreCliente = nombreCliente;
        this.asunto = asunto;
        this.prioridad = prioridad;

        estado = "Nuevo";

        historialEstados = new Pila();

        historialEstados.push(estado);
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
        cambiarEstado(estado);
    }

    // Cambiar estado del ticket
    public void cambiarEstado(String nuevoEstado) {

        estado = nuevoEstado;

        historialEstados.push(estado);
    }
    
    public void mostrarHistorial() {

        historialEstados.mostrar();
    }


    public void deshacerEstado() {

        if (historialEstados.size() <= 1) {

            System.out.println("No se puede deshacer el estado inicial.");
            return;
        }

        historialEstados.pop();
        estado = historialEstados.peek();
        System.out.println("Estado actual: " + estado);
    }

    public Pila getHistorialEstados() {
        return historialEstados;
    }
}
