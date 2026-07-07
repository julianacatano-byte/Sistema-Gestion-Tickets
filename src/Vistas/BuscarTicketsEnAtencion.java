package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuscarTicketsEnAtencion {
    private JPanel panel1;
    private JTextField txtNombreCliente;
    private JLabel lblResultado;
    private JButton buscarTicketButton;

    private JFrame frame;
    private final BuscarTicketCallback callback;
    private JButton confirmarButton;
    private JComboBox comboBox1;
    private JTextField textField1;

    public interface BuscarTicketCallback {
        String onBuscarTicket(String nombre);
    }

    public BuscarTicketsEnAtencion(BuscarTicketCallback callback) {
        this.callback = callback;
        inicializarComponentes();
        configurarEventos();
        confirmarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        comboBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
    }

    private void inicializarComponentes() {
        panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 15, 10, 15);

        JLabel lblTitulo = new JLabel("Buscar tickets en atencion");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel1.add(lblTitulo, gbc);

        JLabel lblNombre = new JLabel("Nombre del cliente:");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(lblNombre, gbc);

        txtNombreCliente = new JTextField(10);
        txtNombreCliente.setPreferredSize(new Dimension(150, 28));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel1.add(txtNombreCliente, gbc);

        buscarTicketButton = new JButton("Buscar ticket");
        buscarTicketButton.setPreferredSize(new Dimension(200, 35));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel1.add(buscarTicketButton, gbc);

        lblResultado = new JLabel(" ");
        lblResultado.setFont(new Font("Arial", Font.PLAIN, 13));
        gbc.gridy = 3;
        panel1.add(lblResultado, gbc);
    }

    private void configurarEventos() {
        buscarTicketButton.addActionListener(e -> {
            String resultado = callback.onBuscarTicket(txtNombreCliente.getText().trim());
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
