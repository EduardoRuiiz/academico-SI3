package view;

import controller.EnvioController;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Envio;

public class ConsultaEnviosView extends JFrame {

    public ConsultaEnviosView() {
        setTitle("Consulta de Envios");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] colunas = {"Código", "Remetente", "Destinatário", "Tipo de Entrega"};

        EnvioController controller = new EnvioController();
        List<Envio> listaEnvios = controller.listarEnvios();

        // Modelo para a tabela
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        // Preenche o modelo com os dados da lista
        for (Envio envio : listaEnvios) {
            Object[] linha = {
                envio.getCodigoRastreamento(),
                envio.getRemetente().getNome(),
                envio.getDestinatario().getNome(),
                envio.getTipoEntrega().toString()
            };
            model.addRow(linha);
        }

        JTable tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll);
    }
}
