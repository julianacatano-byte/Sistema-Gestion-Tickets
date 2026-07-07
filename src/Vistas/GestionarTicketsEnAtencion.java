package Vistas;

import Controladores.PanelPrincipalController;

import javax.swing.*;

public class GestionarTicketsEnAtencion {


    private JPanel panel;
    private JTextField txtId;

    private JButton buscarTicketButton;
    private JButton cambiarEstadoButton;
    private JButton cambiarPrioridadButton;
    private JButton mostrarHistorialButton;
    private JButton mostrarTicketsInicioFinButton;
    private JButton mostrarTicketsFinInicioButton;
    private JButton deshacerUltimoCambioButton;
    private JButton cerrarTicketButton;
    private JButton volverButton;
    private JTextField textField1;

    private final PanelPrincipalController controller;

    public GestionarTicketsEnAtencion(PanelPrincipalController controller) {

        this.controller = controller;

        System.out.println(panel);
        System.out.println(txtId);
        System.out.println(buscarTicketButton);

        configurarEventos();
    }

    public JPanel getPanel() {
        return panel;
    }

    private void configurarEventos() {

        buscarTicketButton.addActionListener(e -> {

            String id = txtId.getText().trim();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(panel,
                        "Ingrese el número del ticket.");
                return;
            }

            controller.buscarTicket(id);
        });

        cambiarPrioridadButton.addActionListener(e -> {

            String id = txtId.getText().trim();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(panel,
                        "Ingrese el número del ticket.");
                return;
            }

            controller.cambiarPrioridad(id);
        });

        cambiarEstadoButton.addActionListener(e -> {

            String id = txtId.getText().trim();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(panel,
                        "Ingrese el número del ticket.");
                return;
            }

            controller.cambiarEstado(id);
        });

        mostrarHistorialButton.addActionListener(e -> {

            String id = txtId.getText().trim();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(panel,
                        "Ingrese el número del ticket.");
                return;
            }

            controller.mostrarHistorial(id);
        });

        deshacerUltimoCambioButton.addActionListener(e -> {

            String id = txtId.getText().trim();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(panel,
                        "Ingrese el número del ticket.");
                return;
            }

            controller.deshacerEstado(id);
        });

        cerrarTicketButton.addActionListener(e -> {

            String id = txtId.getText().trim();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(panel,
                        "Ingrese el número del ticket.");
                return;
            }

            controller.cerrarTicket(id);
        });

        mostrarTicketsInicioFinButton.addActionListener(e ->
                controller.mostrarTicketsInicioFin());

        mostrarTicketsFinInicioButton.addActionListener(e ->
                controller.mostrarTicketsFinInicio());

        volverButton.addActionListener(e ->
                controller.volverMenuPrincipal());
    }
}