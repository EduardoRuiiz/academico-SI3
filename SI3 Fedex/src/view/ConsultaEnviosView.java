package view;

import javax.swing.*;

public class ConsultaEnviosView extends JFrame {

    public ConsultaEnviosView() {
        setTitle("Consulta de Envios");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] colunas = {"Código", "Remetente", "Destinatário", "Tipo de Entrega"};
        Object[][] dados = {};
        JTable tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll);
    }
}
