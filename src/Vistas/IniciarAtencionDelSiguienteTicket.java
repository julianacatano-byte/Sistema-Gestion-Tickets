package Vistas;

import javax.swing.*;

public class IniciarAtencionDelSiguienteTicket {
    private JPanel panel1;
    private JLabel lblCliente;
    private JLabel lblAsunto;
    private JLabel lblPrioridad;
    private JLabel lblEstado;
    private JButton btnIniciarAtencion;
    private JButton btnCancelar;

    private JDialog dialog;
    private boolean atencionIniciada;

    public IniciarAtencionDelSiguienteTicket(String cliente, String asunto, String prioridad, String estado) {
        atencionIniciada = false;
        lblCliente.setText(cliente);
        lblAsunto.setText(asunto);
        lblPrioridad.setText(prioridad);
        lblEstado.setText(estado);
        configurarEventos();
    }

    private void configurarEventos() {
        btnIniciarAtencion.addActionListener(e -> {
            atencionIniciada = true;
            cerrar();
        });

        btnCancelar.addActionListener(e -> cerrar());
    }

    public boolean isAtencionIniciada() {
        return atencionIniciada;
    }

    public void mostrar(JFrame parent) {
        dialog = new JDialog(parent, "Iniciar Atencion", true);
        dialog.setContentPane(panel1);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(450, 350);
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }

    public void cerrar() {
        if (dialog != null) {
            dialog.dispose();
        }
    }
}
