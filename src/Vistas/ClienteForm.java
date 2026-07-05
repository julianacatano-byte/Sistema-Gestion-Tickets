package Vistas;

import Controladores.ClienteController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClienteForm {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox<String> comboBox1;
    private JButton confirmarButton;
    private final ClienteController controller;
    private final LoginForm ventanaAnterior;
    private JFrame frame;
    private boolean ticketCreado;

    public ClienteForm(ClienteController controller, LoginForm ventanaAnterior) {
        this.controller = controller;
        this.ventanaAnterior = ventanaAnterior;
        inicializarComponentes();
        configurarEventos();
    }

    @SuppressWarnings("unchecked")
    private void inicializarComponentes() {
        panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 15, 8, 15);

        JLabel lblTitulo = new JLabel("Ingrese la informacion del ticket:");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        panel1.add(lblTitulo, gbc);

        JLabel lblNombre = new JLabel("Ingrese su nombre:");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 13));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel1.add(lblNombre, gbc);

        textField1 = new JTextField(20);
        textField1.setPreferredSize(new Dimension(200, 28));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        panel1.add(textField1, gbc);

        JLabel lblAsunto = new JLabel("Ingrese el asunto:");
        lblAsunto.setFont(new Font("Arial", Font.PLAIN, 13));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        panel1.add(lblAsunto, gbc);

        textField2 = new JTextField(20);
        textField2.setPreferredSize(new Dimension(200, 28));
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel1.add(textField2, gbc);

        JLabel lblPrioridad = new JLabel("Prioridad:");
        lblPrioridad.setFont(new Font("Arial", Font.PLAIN, 13));
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel1.add(lblPrioridad, gbc);

        comboBox1 = new JComboBox<>(new String[]{"ALTA", "MEDIA", "BAJA"});
        comboBox1.setPreferredSize(new Dimension(150, 28));
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel1.add(comboBox1, gbc);

        confirmarButton = new JButton("Confirmar");
        confirmarButton.setPreferredSize(new Dimension(150, 35));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.insets = new Insets(20, 15, 8, 15);
        panel1.add(confirmarButton, gbc);
    }

    private void configurarEventos() {
        confirmarButton.addActionListener(e -> controller.onConfirmarClick());
    }

    public void marcarTicketCreado() {
        this.ticketCreado = true;
    }

    public JTextField getNombreField() {
        return textField1;
    }

    public JTextField getAsuntoField() {
        return textField2;
    }

    public JComboBox<String> getPrioridadCombo() {
        return comboBox1;
    }

    public JPanel getPanel() {
        return panel1;
    }

    public void mostrar() {
        frame = new JFrame("Registro de Ticket");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 420);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (!ticketCreado && ventanaAnterior != null) {
                    ventanaAnterior.mostrar();
                }
            }
        });
        frame.setVisible(true);
    }

    public void cerrar() {
        if (frame != null) {
            frame.dispose();
        }
    }
}
