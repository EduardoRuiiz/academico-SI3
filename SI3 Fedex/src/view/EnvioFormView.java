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

public class EnvioFormView extends JFrame {

    public EnvioFormView() {
        setTitle("Cadastro de Envio");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DestinatarioDAO destinatarioDAO = new DestinatarioDAO();
        RemetenteDAO remetenteDAO = new RemetenteDAO();
        List<Destinatario> destinatarios = destinatarioDAO.listarDestinatarios();
        List<Remetente> remetentes = remetenteDAO.listarRemetentes();

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        JLabel lblRemetente = new JLabel("Remetente:");
        JComboBox<Remetente> comboRemetente = new JComboBox<>(remetentes.toArray(new Remetente[0]));
        JLabel lblDestinatario = new JLabel("Destinatário:");
        JComboBox<Destinatario> comboDestinatario = new JComboBox<>(destinatarios.toArray(new Destinatario[0]));
        JLabel lblEntrega = new JLabel("Tipo de Entrega:");
        String[] tiposEntrega = {"Aéreo", "Rodoviário"};
        JComboBox<String> comboTipoEntrega = new JComboBox<>(tiposEntrega);
        JLabel lblPeso = new JLabel("Peso (kg):");
        JTextField txtPeso = new JTextField();
        JLabel lblDataEnvio = new JLabel("Data de Envio (DD-MM-AAAA):");
        JTextField txtDataEnvio = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

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
        add(panel);

        btnSalvar.addActionListener(e -> {
            Remetente remetente = (Remetente) comboRemetente.getSelectedItem();
            Destinatario destinatario = (Destinatario) comboDestinatario.getSelectedItem();
            String tipoEntregaSelecionado = (String) comboTipoEntrega.getSelectedItem();

            TipoEntrega tipoEntrega = tipoEntregaSelecionado.equals("Aéreo")
                    ? TipoEntrega.AEREO
                    : TipoEntrega.RODOVIARIO;

            try {
                BigDecimal peso = new BigDecimal(txtPeso.getText());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate localDate = LocalDate.parse(txtDataEnvio.getText(), formatter);
                java.sql.Date dataEnvio = java.sql.Date.valueOf(localDate);

                Envio envio = new Envio(
                        0,
                        destinatario,
                        remetente,
                        tipoEntrega,
                        peso,
                        dataEnvio,
                        "PENDENTE"
                );

                EnvioController controller = new EnvioController();
                boolean sucesso = controller.salvarEnvio(envio);

                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Envio salvo com sucesso!\nCódigo: " + envio.getCodigoRastreamento());
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar envio.");
                }
                if (controller.salvarEnvio(envio)) {
                    JOptionPane.showMessageDialog(this, "Envio cadastrado com sucesso!");

                    EtiquetaView etiqueta = new EtiquetaView(
                            envio.getCodigoRastreamento(),
                            envio.getRemetente().getNome(),
                            envio.getDestinatario().getNome(),
                            envio.getTipoEntrega().toString()
                    );
                    etiqueta.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar o envio!");
                }

            } catch (DateTimeParseException dtpe) {
                JOptionPane.showMessageDialog(this, "Data inválida. Use o formato DD-MM-AAAA.");
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Peso inválido. Use apenas números.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao processar envio: " + ex.getMessage());
            }
        });
    }
}
