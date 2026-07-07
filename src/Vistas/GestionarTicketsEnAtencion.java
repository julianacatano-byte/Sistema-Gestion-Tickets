package Vistas;

import Estructuras.ListaDobleEnlazada;

import javax.swing.*;

public class GestionarTicketsEnAtencion {
    private JPanel panel1;
    private JButton cambiarPrioridadButton;
    private JButton eliminarTicketButton;

    private final ListaDobleEnlazada lista;
    private JFrame frame;

    public GestionarTicketsEnAtencion(ListaDobleEnlazada lista) {
        this.lista = lista;
        configurarEventos();
    }

    private void configurarEventos() {
    }

    public JPanel getPanel() {
        return panel1;
    }

    public void mostrar() {
        frame = new JFrame("Gestionar Tickets en Atencion");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(520, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
