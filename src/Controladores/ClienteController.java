package Controladores;

import Modelos.Ticket;
import Vistas.ClienteForm;
import Vistas.LoginForm;

import javax.swing.*;
import java.util.List;

public class ClienteController {
    private final List<Ticket> tickets;
    private ClienteForm vista;
    private LoginForm ventanaAnterior;

    public ClienteController(List<Ticket> tickets) {
        this.tickets = tickets;
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
        if (!validarCampos()) return;

        String nombre = vista.getNombreField().getText().trim();
        String asunto = vista.getAsuntoField().getText().trim();
        String prioridad = (String) vista.getPrioridadCombo().getSelectedItem();

        Ticket ticket = new Ticket(nombre, asunto, prioridad);
        tickets.add(ticket);

        vista.marcarTicketCreado();
        JOptionPane.showMessageDialog(
                vista.getPanel(),
                "Ticket creado exitosamente.\nNombre: " + nombre +
                        "\nAsunto: " + asunto + "\nPrioridad: " + prioridad,
                "\u00c9xito",
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
