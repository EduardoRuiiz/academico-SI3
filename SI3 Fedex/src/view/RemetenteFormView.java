package view;

import controller.RemetenteController;
import java.awt.*;
import javax.swing.*;

public class RemetenteFormView extends JFrame {

    // Construtor da janela de cadastro de remetente
    public RemetenteFormView() {
        // Define o título da janela
        setTitle("Cadastro de Remetente");
        // Define o tamanho da janela (largura x altura)
        setSize(350, 250);
        // Centraliza a janela na tela
        setLocationRelativeTo(null);
        // Fecha somente esta janela ao clicar no "X"
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Cria painel com GridLayout de 2 colunas e espaçamento de 5px
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

        // Cria labels e campos de texto para os dados do remetente
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblEndereco = new JLabel("Endereço:");
        JTextField txtEndereco = new JTextField();
        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField();
        JLabel lblCnpj = new JLabel("CNPJ:");
        JTextField txtCnpj = new JTextField();

        // Botão para salvar os dados do remetente
        JButton btnSalvar = new JButton("Salvar");

        // Adiciona os componentes ao painel em ordem (label, campo)
        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblEndereco);
        panel.add(txtEndereco);
        panel.add(lblTelefone);
        panel.add(txtTelefone);
        panel.add(lblCnpj);
        panel.add(txtCnpj);

        // Adiciona um label vazio para ocupar espaço e posicionar botão
        panel.add(new JLabel()); // espaço vazio
        // Adiciona o botão salvar no grid
        panel.add(btnSalvar);

        // Adiciona o painel à janela
        add(panel);

        // Ação executada ao clicar no botão salvar
        btnSalvar.addActionListener(e -> {
            // Obtém os textos digitados pelo usuário
            String nome = txtNome.getText();
            String endereco = txtEndereco.getText();
            String telefone = txtTelefone.getText();
            String cnpj = txtCnpj.getText();

            // Cria o controller para tratar o cadastro
            RemetenteController controller = new RemetenteController();

            // Chama o método de cadastro e captura o resultado
            boolean sucesso = controller.cadastrar(nome, cnpj, endereco, telefone);

            // Exibe mensagem conforme o resultado do cadastro
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Remetente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                // Fecha a janela após cadastro bem-sucedido
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar remetente. Verifique os dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
