package view;

import java.awt.*;
import javax.swing.*;

public class MainView extends JFrame {

    public MainView() {
        setTitle("Fedex - Sistema de Envio");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuCadastros = new JMenu("Cadastros");
        JMenuItem menuRemetente = new JMenuItem("Remetente");
        JMenuItem menuDestinatario = new JMenuItem("Destinatário");
        JMenuItem menuEnvio = new JMenuItem("Envio");
        menuCadastros.add(menuRemetente);
        menuCadastros.add(menuDestinatario);
        menuCadastros.add(menuEnvio);
        menuBar.add(menuCadastros);
        setJMenuBar(menuBar);

        JLabel label = new JLabel("Bem-vindo ao Sistema Fedex!", SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
