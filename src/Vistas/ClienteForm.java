package Vistas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClienteForm {
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JButton confirmarButton;

    public ClienteForm() {
        confirmarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}
