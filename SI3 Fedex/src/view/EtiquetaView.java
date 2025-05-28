package view;

import java.awt.*;
import javax.swing.*;

public class EtiquetaView extends JFrame {

    public EtiquetaView(String codigo, String remetente, String destinatario, String tipoEntrega) {
        setTitle("Etiqueta de Envio");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Código: " + codigo));
        panel.add(new JLabel("Remetente: " + remetente));
        panel.add(new JLabel("Destinatário: " + destinatario));
        panel.add(new JLabel("Tipo de Entrega: " + tipoEntrega));
        add(panel);
    }
}
