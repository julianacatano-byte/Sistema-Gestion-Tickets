package Controladores;

import Modelos.ColaTickets;
import Modelos.Ticket;
import Vistas.ClienteForm;
import Vistas.LoginForm;

import javax.swing.*;
import java.util.List;

public class ClienteController {

    private final List<Ticket> tickets;
    private final ColaTickets colaTickets;

    private ClienteForm vista;
    private LoginForm ventanaAnterior;

    public ClienteController(List<Ticket> tickets, ColaTickets colaTickets) {
        this.tickets = tickets;
        this.colaTickets = colaTickets;
    }

    public void setVentanaAnterior(LoginForm ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
    }

    public void mostrarFormulario() {
        this.vista = new ClienteForm(this, ventanaAnterior);
        this.vista.mostrar();
    }

    public void onConfirmarClick() {
        handleConfirmarClick();
    }

    private void handleConfirmarClick() {

        if (!validarCampos()) {
            return;
        }

        String nombre = vista.getNombreField().getText().trim();
        String asunto = vista.getAsuntoField().getText().trim();
        String prioridad = (String) vista.getPrioridadCombo().getSelectedItem();

        Ticket ticket = new Ticket(nombre, asunto, prioridad);

        // Se guarda en la lista que usa el proyecto
        tickets.add(ticket);


        colaTickets.encolar(ticket);

        vista.marcarTicketCreado();

        JOptionPane.showMessageDialog(
                vista.getPanel(),
                "Ticket creado exitosamente.\nNombre: " + nombre +
                        "\nAsunto: " + asunto +
                        "\nPrioridad: " + prioridad,
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE
        );

        vista.cerrar();
        ventanaAnterior.mostrar();
    }

    private boolean validarCampos() {

        if (vista.getNombreField().getText().trim().isEmpty()) {
            mostrarError("Debe ingresar su nombre");
            return false;
        }

        if (vista.getAsuntoField().getText().trim().isEmpty()) {
            mostrarError("Debe ingresar el asunto");
            return false;
        }

        return true;
    }

    private void mostrarError(String mensaje) {

        JOptionPane.showMessageDialog(
                vista.getPanel(),
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}