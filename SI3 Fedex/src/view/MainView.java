package view;

import java.awt.*;
import javax.swing.*;

public class MainView extends JFrame {

    public MainView() {
        setTitle("Fedex - Sistema de Envio");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245));

        // Logo real redimensionado
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/img/Fedex-logo.png"));
        Image img = logoIcon.getImage();
        Image scaledImg = img.getScaledInstance(-1, 120, Image.SCALE_SMOOTH); // altura máxima 120px
        logoIcon = new ImageIcon(scaledImg);
        JLabel logo = new JLabel(logoIcon, SwingConstants.CENTER);
        logo.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        mainPanel.add(logo, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 60));

        JLabel label = new JLabel("Bem-vindo ao Sistema Fedex!", SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Arial", Font.BOLD, 22));
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        centerPanel.add(label);

        JButton btnRemetente = new JButton("Cadastro de Remetente");
        JButton btnDestinatario = new JButton("Cadastro de Destinatário");
        JButton btnEnvio = new JButton("Cadastro de Envio");
        JButton btnConsulta = new JButton("Consulta de Envios");

        // Tooltips
        btnRemetente.setToolTipText("Cadastrar um novo remetente");
        btnDestinatario.setToolTipText("Cadastrar um novo destinatário");
        btnEnvio.setToolTipText("Cadastrar um novo envio e gerar código");
        btnConsulta.setToolTipText("Consultar todos os envios cadastrados");

        // Cores diferentes
        Color[] cores = {
            new Color(66, 133, 244), // azul
            new Color(52, 168, 83), // verde
            new Color(251, 188, 5), // amarelo
            new Color(234, 67, 53) // vermelho
        };
        JButton[] buttons = {btnRemetente, btnDestinatario, btnEnvio, btnConsulta};
        for (int i = 0; i < buttons.length; i++) {
            JButton btn = buttons[i];
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(300, 45));
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.setFocusPainted(false);
            btn.setBackground(cores[i]);
            btn.setForeground(Color.WHITE);
            btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(cores[i].darker(), 2, true),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)));
            // Efeito hover
            Color normal = cores[i];
            Color hover = normal.brighter();
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(hover);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setBackground(normal);
                }
            });
            centerPanel.add(btn);
            centerPanel.add(Box.createRigidArea(new Dimension(0, 18)));
        }

        btnRemetente.addActionListener(e -> new RemetenteFormView().setVisible(true));
        btnDestinatario.addActionListener(e -> new DestinatarioFormView().setVisible(true));
        btnEnvio.addActionListener(e -> new EnvioFormView().setVisible(true));
        btnConsulta.addActionListener(e -> new ConsultaEnviosView().setVisible(true));

        // Centralizar verticalmente
        JPanel verticalCenter = new JPanel();
        verticalCenter.setLayout(new BoxLayout(verticalCenter, BoxLayout.Y_AXIS));
        verticalCenter.setOpaque(false);
        verticalCenter.add(Box.createVerticalGlue());
        verticalCenter.add(centerPanel);
        verticalCenter.add(Box.createVerticalGlue());
        mainPanel.add(verticalCenter, BorderLayout.CENTER);

        // Rodapé
        JLabel rodape = new JLabel("Fedex © 2025", SwingConstants.CENTER);
        rodape.setFont(new Font("Arial", Font.PLAIN, 12));
        rodape.setForeground(new Color(120, 120, 120));
        rodape.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        mainPanel.add(rodape, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }
}
