package Modelos;

import Estructuras.Pila;

public class Ticket {

    private static int contador = 0;
    private int id;

    private String nombreCliente;
    private String asunto;
    private Prioridad prioridad;
    private Estado estado;
    private Pila<Estado> historialEstados;

    public Ticket(String nombreCliente, String asunto, Prioridad prioridad) {
        this.id = ++contador;
        this.nombreCliente = nombreCliente;
        this.asunto = asunto;
        this.prioridad = prioridad;

        this.estado = Estado.NUEVO;

        this.historialEstados = new Pila<>();
        this.historialEstados.push(this.estado);
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

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public String getPrioridadDisplay() {
        return prioridad.getDisplayName();
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getEstadoDisplay() {
        return estado.getDisplayName();
    }

    public void setEstado(Estado estado) {
        cambiarEstado(estado);
    }

    // Cambiar el estado del ticket
    public void cambiarEstado(Estado nuevoEstado) {
        this.estado = nuevoEstado;
        historialEstados.push(nuevoEstado);
    }

    // Mostrar historial de estados
    public void mostrarHistorial() {
        if (historialEstados.isEmpty()) {
            System.out.println("No hay historial de estados.");
            return;
        }

        System.out.println("Historial del ticket:");
        historialEstados.mostrar();
    }

    // Deshacer el último cambio de estado
    public void deshacerEstado() {

        if (historialEstados.size() <= 1) {
            System.out.println("No se puede deshacer el estado inicial.");
            return;
        }

        historialEstados.pop();

        estado = historialEstados.peek();

        System.out.println("Estado actual: " + estado.getDisplayName());
    }

    public Pila<Estado> getHistorialEstados() {
        return historialEstados;
    }
}