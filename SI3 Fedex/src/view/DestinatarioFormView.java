package view;

import controller.DestinatarioController;
import java.awt.*;
import javax.swing.*;

public class DestinatarioFormView extends JFrame {

    public DestinatarioFormView() {
        setTitle("Cadastro de Destinatário");
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
        JLabel lblCpf = new JLabel("CPF:");
        JTextField txtCpf = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblEndereco);
        panel.add(txtEndereco);
        panel.add(lblTelefone);
        panel.add(txtTelefone);
        panel.add(lblCpf);
        panel.add(txtCpf);
        panel.add(btnSalvar);
        add(panel);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String endereco = txtEndereco.getText();
            String telefone = txtTelefone.getText();
            String cpf = txtCpf.getText();
            DestinatarioController controller = new DestinatarioController();
            boolean sucesso = controller.cadastrar(nome, cpf, endereco, telefone);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Destinatário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar destinatário. Verifique os dados", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
