package Modelos;

import java.util.Stack;

public class Ticket {
    private static int contador = 0;
    private int id;

    private String nombreCliente;
    private String asunto;
    private Prioridad prioridad;
    private Estado estado;

    private Stack<String> historialEstados = new Stack<>();

    public Ticket(String nombreCliente, String asunto, Prioridad prioridad) {
        this.id = ++contador;
        this.nombreCliente = nombreCliente;
        this.asunto = asunto;
        this.prioridad = prioridad;
        this.estado = Estado.PENDIENTE;
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

    public void cambiarEstado(Estado nuevoEstado) {
        if (historialEstados.isEmpty()) {
            historialEstados.push(estado.name());
        }
        estado = nuevoEstado;
        historialEstados.push(estado.name());
    }

    public void mostrarHistorial() {
        if (historialEstados.isEmpty()) {
            System.out.println("No hay historial de estados.");
            return;
        }
        System.out.println("Historial del ticket:");
        for (String est : historialEstados) {
            System.out.println(est);
        }
    }

    public void deshacerEstado() {
        if (historialEstados.size() <= 1) {
            System.out.println("No hay estados para deshacer.");
            return;
        }
        historialEstados.pop();
        estado = Estado.valueOf(historialEstados.peek());
        System.out.println("Estado actual: " + estado.getDisplayName());
    }

    public Stack<String> getHistorialEstados() {
        return historialEstados;
    }
}
