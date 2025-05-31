package view;

import controller.EnvioController;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Envio;

// Classe que representa a janela (tela) para consulta dos envios
public class ConsultaEnviosView extends JFrame {

    // Construtor da classe que monta a interface
    public ConsultaEnviosView() {
        // Define o título da janela
        setTitle("Consulta de Envios");

        // Define o tamanho da janela
        setSize(600, 400);

        // Centraliza a janela na tela
        setLocationRelativeTo(null);

        // Define o que acontece ao fechar a janela (nesse caso, apenas ela será fechada)
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Define os nomes das colunas da tabela
        String[] colunas = {"Código", "Remetente", "Destinatário", "Tipo de Entrega"};

        // Cria o controlador para acessar os dados de envio
        EnvioController controller = new EnvioController();

        // Obtém a lista de envios do banco de dados
        List<Envio> listaEnvios = controller.listarEnvios();

        // Cria um modelo de tabela com as colunas definidas e nenhuma linha inicialmente
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        // Percorre a lista de envios e adiciona cada envio como uma nova linha na tabela
        for (Envio envio : listaEnvios) {
            Object[] linha = {
                envio.getCodigoRastreamento(), // Código de rastreamento
                envio.getRemetente().getNome(), // Nome do remetente
                envio.getDestinatario().getNome(), // Nome do destinatário
                envio.getTipoEntrega().toString() // Tipo de entrega (AEREO/RODOVIARIO)
            };
            model.addRow(linha); // Adiciona a linha ao modelo
        }

        // Cria uma tabela com o modelo preenchido
        JTable tabela = new JTable(model);

        // Adiciona a tabela em um painel de rolagem
        JScrollPane scroll = new JScrollPane(tabela);

        // Adiciona o painel de rolagem (com a tabela) à janela
        add(scroll);
    }
}
