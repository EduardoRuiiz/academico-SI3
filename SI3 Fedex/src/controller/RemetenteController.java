package controller;

import dao.RemetenteDAO;
import model.Remetente;

public class RemetenteController {

    private RemetenteDAO dao = new RemetenteDAO();

    public boolean cadastrar(String nome, String endereco, String telefone) {
        if (nome == null || nome.isEmpty() || endereco == null || endereco.isEmpty()) {
            return false; // Validação simples
        }
        Remetente remetente = new Remetente(0, nome, null, endereco, telefone);
        return dao.inserir(remetente);
    }
}
