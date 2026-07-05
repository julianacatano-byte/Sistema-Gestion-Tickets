package Vistas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminLoginForm {
    private JPasswordField passwordField1;
    private JPanel panel1;
    private JTextField textField1;
    private JButton confirmarButton;

    public AdminLoginForm() {
        confirmarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}
