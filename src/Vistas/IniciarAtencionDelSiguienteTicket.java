package Vistas;

import javax.swing.*;
import java.awt.*;

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
        inicializarComponentes(cliente, asunto, prioridad, estado);
        configurarEventos();
    }

    private void inicializarComponentes(String cliente, String asunto, String prioridad, String estado) {
        panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 15, 10, 15);

        JLabel lblTitulo = new JLabel("Iniciar Atencion del Siguiente Ticket");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel1.add(lblTitulo, gbc);

        JLabel lblClienteLabel = new JLabel("Cliente:");
        lblClienteLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(lblClienteLabel, gbc);

        lblCliente = new JLabel(cliente);
        lblCliente.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel1.add(lblCliente, gbc);

        JLabel lblAsuntoLabel = new JLabel("Asunto:");
        lblAsuntoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(lblAsuntoLabel, gbc);

        lblAsunto = new JLabel(asunto);
        lblAsunto.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel1.add(lblAsunto, gbc);

        JLabel lblPrioridadLabel = new JLabel("Prioridad:");
        lblPrioridadLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel1.add(lblPrioridadLabel, gbc);

        lblPrioridad = new JLabel(prioridad);
        lblPrioridad.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel1.add(lblPrioridad, gbc);

        JLabel lblEstadoLabel = new JLabel("Estado:");
        lblEstadoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel1.add(lblEstadoLabel, gbc);

        lblEstado = new JLabel(estado);
        lblEstado.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel1.add(lblEstado, gbc);

        btnIniciarAtencion = new JButton("Iniciar atencion");
        btnIniciarAtencion.setPreferredSize(new Dimension(180, 35));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 15, 10, 10);
        panel1.add(btnIniciarAtencion, gbc);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setPreferredSize(new Dimension(180, 35));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.insets = new Insets(20, 10, 10, 15);
        panel1.add(btnCancelar, gbc);
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
