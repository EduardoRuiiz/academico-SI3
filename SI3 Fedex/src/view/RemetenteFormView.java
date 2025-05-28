package view;

import controller.RemetenteController;
import java.awt.*;
import javax.swing.*;

public class RemetenteFormView extends JFrame {

    public RemetenteFormView() {
        setTitle("Cadastro de Remetente");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblEndereco = new JLabel("Endereço:");
        JTextField txtEndereco = new JTextField();
        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblEndereco);
        panel.add(txtEndereco);
        panel.add(lblTelefone);
        panel.add(txtTelefone);
        panel.add(new JLabel()); // espaço vazio
        panel.add(btnSalvar);
        add(panel);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String endereco = txtEndereco.getText();
            String telefone = txtTelefone.getText();
            RemetenteController controller = new RemetenteController();
            boolean sucesso = controller.cadastrar(nome, endereco, telefone);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Remetente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar remetente. Verifique os dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
