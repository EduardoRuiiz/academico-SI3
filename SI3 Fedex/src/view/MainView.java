package view;

import java.awt.*;
import javax.swing.*;

public class MainView extends JFrame {

    // Construtor da janela principal do sistema Fedex
    public MainView() {
        // Define o título da janela
        setTitle("Fedex - Sistema de Envio");
        // Define o tamanho da janela (largura x altura)
        setSize(500, 500);
        // Configura o encerramento do programa ao fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centraliza a janela na tela
        setLocationRelativeTo(null);

        // Cria o painel principal com layout BorderLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        // Define a cor de fundo do painel principal
        mainPanel.setBackground(new Color(245, 245, 245));

        // Carrega o ícone do logo a partir do recurso no pacote /img/
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/img/Fedex-logo.png"));
        // Obtém a imagem do ícone para redimensionamento
        Image img = logoIcon.getImage();
        // Redimensiona a imagem mantendo a proporção, com altura máxima de 120 pixels
        Image scaledImg = img.getScaledInstance(-1, 120, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(scaledImg);
        // Cria um JLabel com o logo centralizado
        JLabel logo = new JLabel(logoIcon, SwingConstants.CENTER);
        // Define uma margem superior para o logo
        logo.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        // Adiciona o logo na região norte do BorderLayout do painel principal
        mainPanel.add(logo, BorderLayout.NORTH);

        // Cria um painel central com layout vertical (BoxLayout Y_AXIS)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        // Deixa o painel transparente para mostrar a cor do painel pai
        centerPanel.setOpaque(false);
        // Define margens internas do painel central
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 60));

        // Cria um label de boas-vindas com alinhamento central e fonte personalizada
        JLabel label = new JLabel("Bem-vindo ao Sistema Fedex!", SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Arial", Font.BOLD, 22));
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        // Adiciona o label ao painel central
        centerPanel.add(label);

        // Cria os botões principais do sistema
        JButton btnRemetente = new JButton("Cadastro de Remetente");
        JButton btnDestinatario = new JButton("Cadastro de Destinatário");
        JButton btnEnvio = new JButton("Cadastro de Envio");
        JButton btnConsulta = new JButton("Consulta de Envios");

        // Define textos de ajuda para cada botão (tooltips)
        btnRemetente.setToolTipText("Cadastrar um novo remetente");
        btnDestinatario.setToolTipText("Cadastrar um novo destinatário");
        btnEnvio.setToolTipText("Cadastrar um novo envio e gerar código");
        btnConsulta.setToolTipText("Consultar todos os envios cadastrados");

        // Define cores para os botões (roxo e laranja)
        Color roxo = new Color(87, 41, 142);
        Color laranja = new Color(255, 102, 0);
        Color[] cores = {roxo, laranja, roxo, laranja};
        JButton[] buttons = {btnRemetente, btnDestinatario, btnEnvio, btnConsulta};

        // Configura estilo e comportamento visual dos botões
        for (int i = 0; i < buttons.length; i++) {
            JButton btn = buttons[i];
            // Centraliza horizontalmente
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            // Define tamanho máximo fixo
            btn.setMaximumSize(new Dimension(300, 45));
            // Define fonte em negrito e tamanho 16
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            // Remove efeito padrão de foco
            btn.setFocusPainted(false);
            // Define cor de fundo e cor do texto
            btn.setBackground(cores[i]);
            btn.setForeground(Color.WHITE);
            // Cria bordas arredondadas com cor ligeiramente mais escura e espaçamento interno
            btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(cores[i].darker(), 2, true),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)));

            // Adiciona efeito hover: clarear cor ao passar mouse, restaurar ao sair
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
            // Adiciona o botão ao painel central
            centerPanel.add(btn);
            // Espaçamento entre botões
            centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        }

        // Define as ações ao clicar em cada botão, abrindo as respectivas janelas de cadastro ou consulta
        btnRemetente.addActionListener(e -> new RemetenteFormView().setVisible(true));
        btnDestinatario.addActionListener(e -> new DestinatarioFormView().setVisible(true));
        btnEnvio.addActionListener(e -> new EnvioFormView().setVisible(true));
        btnConsulta.addActionListener(e -> new ConsultaEnviosView().setVisible(true));

        // Cria um painel vertical para centralizar o painel central na tela verticalmente
        JPanel verticalCenter = new JPanel();
        verticalCenter.setLayout(new BoxLayout(verticalCenter, BoxLayout.Y_AXIS));
        verticalCenter.setOpaque(false);
        // Adiciona espaços flexíveis antes e depois para centralização vertical
        verticalCenter.add(Box.createVerticalGlue());
        verticalCenter.add(centerPanel);
        verticalCenter.add(Box.createVerticalGlue());
        // Adiciona o painel vertical central ao centro do painel principal
        mainPanel.add(verticalCenter, BorderLayout.CENTER);

        // Cria label do rodapé com copyright e estilo simples
        JLabel rodape = new JLabel("Fedex © 2025", SwingConstants.CENTER);
        rodape.setFont(new Font("Arial", Font.PLAIN, 12));
        rodape.setForeground(new Color(120, 120, 120));
        rodape.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        // Adiciona rodapé à região sul do painel principal
        mainPanel.add(rodape, BorderLayout.SOUTH);

        // Define o painel principal como conteúdo da janela
        setContentPane(mainPanel);
    }
}
