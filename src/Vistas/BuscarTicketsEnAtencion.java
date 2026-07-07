package Vistas;

import javax.swing.*;

public class BuscarTicketsEnAtencion {
    private JPanel panel1;
    private JTextField txtId;
    private JLabel lblResultado;
    private JButton buscarTicketButton;

    private JFrame frame;
    private final BuscarTicketCallback callback;

    public interface BuscarTicketCallback {
        String onBuscarTicket(String nombre);
    }

    public BuscarTicketsEnAtencion(BuscarTicketCallback callback) {
        this.callback = callback;
        configurarEventos();
    }

    private void configurarEventos() {
        buscarTicketButton.addActionListener(e -> {
            String resultado = callback.onBuscarTicket(txtId.getText().trim());
            lblResultado.setText(resultado);
        });
    }

    public void mostrar() {
        frame = new JFrame("Buscar Tickets en Atencion");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void cerrar() {
        if (frame != null)
            frame.dispose();
    }
}
