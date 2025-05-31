package view;

import controller.EnvioController;
import dao.DestinatarioDAO;
import dao.RemetenteDAO;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.*;
import model.Destinatario;
import model.Envio;
import model.Remetente;
import model.TipoEntrega;

// Classe da janela principal que estende JFrame
public class EnvioFormView extends JFrame {

    public EnvioFormView() {
        // Define o título da janela
        setTitle("Cadastro de Envio");
        // Define tamanho da janela (largura x altura)
        setSize(400, 300);
        // Centraliza a janela na tela
        setLocationRelativeTo(null);
        // Fecha janela sem encerrar app
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Cria objetos DAO para acessar dados de destinatários e remetentes do banco
        DestinatarioDAO destinatarioDAO = new DestinatarioDAO();
        RemetenteDAO remetenteDAO = new RemetenteDAO();

        // Busca lista de destinatários e remetentes para popular os combos
        List<Destinatario> destinatarios = destinatarioDAO.listarDestinatarios();
        List<Remetente> remetentes = remetenteDAO.listarRemetentes();

        // Cria painel com layout de grid (2 colunas, linhas variáveis, espaçamento 5px)
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

        // Criação dos componentes visuais do formulário
        JLabel lblRemetente = new JLabel("Remetente:");
        JComboBox<Remetente> comboRemetente = new JComboBox<>(remetentes.toArray(new Remetente[0]));
        JLabel lblDestinatario = new JLabel("Destinatário:");
        JComboBox<Destinatario> comboDestinatario = new JComboBox<>(destinatarios.toArray(new Destinatario[0]));
        JLabel lblEntrega = new JLabel("Tipo de Entrega:");
        JComboBox<TipoEntrega> comboTipoEntrega = new JComboBox<>(TipoEntrega.values());
        JLabel lblPeso = new JLabel("Peso (kg):");
        JTextField txtPeso = new JTextField();
        JLabel lblDataEnvio = new JLabel("Data de Envio (DD-MM-AAAA):");
        JTextField txtDataEnvio = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        // Adiciona os componentes ao painel na ordem certa para o grid
        panel.add(lblRemetente);
        panel.add(comboRemetente);
        panel.add(lblDestinatario);
        panel.add(comboDestinatario);
        panel.add(lblEntrega);
        panel.add(comboTipoEntrega);
        panel.add(lblPeso);
        panel.add(txtPeso);
        panel.add(lblDataEnvio);
        panel.add(txtDataEnvio);
        panel.add(btnSalvar);

        // Adiciona o painel à janela JFrame
        add(panel);

        // Evento disparado ao clicar no botão salvar
        btnSalvar.addActionListener(e -> {
            // Pega o remetente selecionado no combo
            Remetente remetente = (Remetente) comboRemetente.getSelectedItem();
            // Pega o destinatário selecionado no combo
            Destinatario destinatario = (Destinatario) comboDestinatario.getSelectedItem();
            // Pega o tipo de entrega selecionado
            TipoEntrega tipoEntrega = (TipoEntrega) comboTipoEntrega.getSelectedItem();

            try {
                // Tenta converter o texto do peso para BigDecimal
                BigDecimal peso = new BigDecimal(txtPeso.getText());

                // Define o formato esperado para a data
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                // Converte a string de texto da data para LocalDate
                LocalDate localDate = LocalDate.parse(txtDataEnvio.getText(), formatter);

                // Converte LocalDate para java.sql.Date para uso no banco
                java.sql.Date dataEnvio = java.sql.Date.valueOf(localDate);

                // Cria objeto Envio com dados informados, código 0 pois será gerado no BD
                Envio envio = new Envio(
                        0,
                        destinatario,
                        remetente,
                        tipoEntrega,
                        peso,
                        dataEnvio,
                        "PENDENTE" // Status inicial do envio
                );

                // Instancia o controller para salvar o envio
                EnvioController controller = new EnvioController();

                // Chama método para salvar e recebe se foi sucesso
                boolean sucesso = controller.salvarEnvio(envio);

                if (sucesso) {
                    // Se salvou com sucesso, mostra mensagem com código de rastreamento
                    JOptionPane.showMessageDialog(this, "Envio salvo com sucesso!\nCódigo: " + envio.getCodigoRastreamento());

                    // Abre a janela da etiqueta com informações do envio
                    EtiquetaView etiqueta = new EtiquetaView(
                            envio.getCodigoRastreamento(),
                            envio.getRemetente().getNome(),
                            envio.getDestinatario().getNome(),
                            envio.getTipoEntrega().toString()
                    );
                    etiqueta.setVisible(true);
                } else {
                    // Caso falhe ao salvar, exibe mensagem de erro
                    JOptionPane.showMessageDialog(this, "Erro ao salvar envio.");
                }

            } catch (DateTimeParseException dtpe) {
                // Tratamento de erro caso data não esteja no formato esperado
                JOptionPane.showMessageDialog(this, "Data inválida. Use o formato DD-MM-AAAA.");
            } catch (NumberFormatException nfe) {
                // Tratamento de erro caso o peso não seja um número válido
                JOptionPane.showMessageDialog(this, "Peso inválido. Use apenas números.");
            } catch (Exception ex) {
                // Tratamento genérico para outras exceções
                JOptionPane.showMessageDialog(this, "Erro ao processar envio: " + ex.getMessage());
            }
        });
    }
}
