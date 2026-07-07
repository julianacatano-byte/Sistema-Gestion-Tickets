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
        this.estado = "Nuevo";

        historialEstados = new Pila();
        historialEstados.push(estado);
    }

    public int getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
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

    /**
     * Cambia el estado del ticket y lo registra en el historial.
     */
    public void cambiarEstado(String nuevoEstado) {

        if (nuevoEstado == null || nuevoEstado.trim().isEmpty()) {
            System.out.println("Estado inválido.");
            return;
        }

        // Evita registrar el mismo estado dos veces seguidas
        if (nuevoEstado.equals(estado)) {
            return;
        }

        estado = nuevoEstado;
        historialEstados.push(estado);
    }

    
    public String mostrarHistorial() {
        return historialEstados.mostrar();
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

    /**
     * Muestra la información del ticket.
     */
    public void mostrarInfo() {

        System.out.println("========== TICKET ==========");
        System.out.println("ID: " + id);
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Asunto: " + asunto);
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Estado: " + estado);
        System.out.println("============================");
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", asunto='" + asunto + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}