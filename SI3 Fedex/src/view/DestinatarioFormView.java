package view;

import java.awt.*;
import javax.swing.*;

public class DestinatarioFormView extends JFrame {

    public DestinatarioFormView() {
        setTitle("Cadastro de Destinatário");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Nome:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Endereço:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Telefone:"));
        panel.add(new JTextField());
        JButton btnSalvar = new JButton("Salvar");
        panel.add(btnSalvar);
        add(panel);
    }
}
