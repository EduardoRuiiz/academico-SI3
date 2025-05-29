package controller;

import dao.DestinatarioDAO;
import model.Destinatario;

public class DestinatarioController {

    private DestinatarioDAO dao = new DestinatarioDAO();

    public boolean cadastrar(String nome, String cpf, String endereco, String telefone) {
        if (nome == null || nome.isEmpty() || endereco == null || endereco.isEmpty() || telefone == null || telefone.isEmpty() || cpf == null || cpf.isEmpty()) {
            return false;
        }
        Destinatario destinatario = new Destinatario(0, nome, cpf, endereco, telefone);

        return dao.inserir(destinatario);
    }
}
