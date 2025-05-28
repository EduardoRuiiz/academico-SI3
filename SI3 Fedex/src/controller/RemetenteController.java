package controller;

import dao.RemetenteDAO;
import model.Remetente;

public class RemetenteController {

    private RemetenteDAO dao = new RemetenteDAO();

    public boolean cadastrar(String nome, String endereco, String telefone, String cpf) {
        if (nome == null || nome.isEmpty() || endereco == null || endereco.isEmpty()) {
            return false; // Validação simples
        }
        Remetente remetente = new Remetente(0, nome, endereco, telefone, cpf);
        return dao.inserir(remetente);
    }
}
