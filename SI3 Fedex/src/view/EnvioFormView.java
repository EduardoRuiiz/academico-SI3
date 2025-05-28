package view;

import java.awt.*;
import javax.swing.*;

public class EnvioFormView extends JFrame {

    public EnvioFormView() {
        setTitle("Cadastro de Envio");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Remetente:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Destinatário:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Tipo de Entrega:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Código de Envio:"));
        panel.add(new JTextField("FDX20250601-0001"));
        JButton btnSalvar = new JButton("Salvar");
        panel.add(btnSalvar);
        add(panel);
    }
}
