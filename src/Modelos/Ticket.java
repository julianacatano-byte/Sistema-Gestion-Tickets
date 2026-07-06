package Modelos;

import java.util.Stack;

public class Ticket {
    private static int contador = 0;
    private int id;

    private String nombreCliente;
    private String asunto;
    private String prioridad;
    private String estado;

    private Stack<String> historialEstados = new Stack<>();

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
        cambiarEstado(estado);
    }

    public void cambiarEstado(String nuevoEstado) {

        if (historialEstados.isEmpty()) {
            historialEstados.push(estado);
        }

        estado = nuevoEstado;
        historialEstados.push(estado);
    }

    public void mostrarHistorial() {

        if (historialEstados.isEmpty()) {
            System.out.println("No hay historial de estados.");
            return;
        }

        System.out.println("Historial del ticket:");

        for (String estado : historialEstados) {
            System.out.println(estado);
        }
    }

    public void deshacerEstado() {

        if (historialEstados.size() <= 1) {
            System.out.println("No hay estados para deshacer.");
            return;
        }
        historialEstados.pop();
        estado = historialEstados.peek();

        System.out.println("Estado actual: " + estado);
    }

    public Stack<String> getHistorialEstados() {
        return historialEstados;
    }

}
