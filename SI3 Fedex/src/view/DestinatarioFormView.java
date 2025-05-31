package view;

import controller.DestinatarioController;
import java.awt.*;
import javax.swing.*;

// Define a classe da janela de cadastro de destinatário, herdando de JFrame
public class DestinatarioFormView extends JFrame {

    // Construtor da classe que monta toda a interface gráfica
    public DestinatarioFormView() {
        // Define o título da janela
        setTitle("Cadastro de Destinatário");

        // Define o tamanho da janela
        setSize(350, 250);

        // Centraliza a janela na tela
        setLocationRelativeTo(null);

        // Define o que acontece ao fechar a janela (somente ela será fechada)
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Cria um painel com layout em grade (linhas x colunas)
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5)); // layout com 2 colunas e espaçamento de 5px

        // Criação dos rótulos e campos de texto para entrada de dados
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();

        JLabel lblEndereco = new JLabel("Endereço:");
        JTextField txtEndereco = new JTextField();

        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField();

        JLabel lblCpf = new JLabel("CPF:");
        JTextField txtCpf = new JTextField();

        // Criação do botão de salvar
        JButton btnSalvar = new JButton("Salvar");

        // Adiciona os componentes ao painel, um a um, alternando rótulo e campo
        panel.add(lblNome);
        panel.add(txtNome);

        panel.add(lblEndereco);
        panel.add(txtEndereco);

        panel.add(lblTelefone);
        panel.add(txtTelefone);

        panel.add(lblCpf);
        panel.add(txtCpf);

        // O botão ocupa uma célula (a outra ficará vazia, pois há 9 componentes em um grid 2xN)
        panel.add(btnSalvar);

        // Adiciona o painel à janela principal
        add(panel);

        // Define a ação ao clicar no botão "Salvar"
        btnSalvar.addActionListener(e -> {
            // Captura os dados inseridos nos campos
            String nome = txtNome.getText();
            String endereco = txtEndereco.getText();
            String telefone = txtTelefone.getText();
            String cpf = txtCpf.getText();

            // Cria uma instância do controller para salvar o destinatário
            DestinatarioController controller = new DestinatarioController();

            // Chama o método de cadastro e guarda o retorno (sucesso ou falha)
            boolean sucesso = controller.cadastrar(nome, cpf, endereco, telefone);

            // Exibe mensagem ao usuário dependendo do resultado
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Destinatário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar destinatário. Verifique os dados", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
