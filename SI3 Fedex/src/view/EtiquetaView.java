package view;

import java.awt.*;
import javax.swing.*;

// Classe da janela que mostra a etiqueta do envio
public class EtiquetaView extends JFrame {

    // Construtor recebe os dados que serão exibidos na etiqueta
    public EtiquetaView(String codigo, String remetente, String destinatario, String tipoEntrega) {
        // Define o título da janela
        setTitle("Etiqueta de Envio");
        // Define o tamanho da janela (largura x altura)
        setSize(350, 200);
        // Centraliza a janela na tela
        setLocationRelativeTo(null);
        // Fecha apenas essa janela sem encerrar o aplicativo
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Cria painel com layout de grid (uma coluna e linhas variáveis)
        JPanel panel = new JPanel(new GridLayout(0, 1));

        // Adiciona labels com os dados recebidos concatenados para exibição
        panel.add(new JLabel("Código: " + codigo));
        panel.add(new JLabel("Remetente: " + remetente));
        panel.add(new JLabel("Destinatário: " + destinatario));
        panel.add(new JLabel("Tipo de Entrega: " + tipoEntrega));

        // Adiciona o painel à janela
        add(panel);
    }
}
