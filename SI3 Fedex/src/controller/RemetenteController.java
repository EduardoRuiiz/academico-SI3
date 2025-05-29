package controller;

import dao.RemetenteDAO;
import model.Remetente;

public class RemetenteController {

    private RemetenteDAO dao = new RemetenteDAO();

    public boolean cadastrar(String nome, String cnpj, String endereco, String telefone) {
        if (nome == null || nome.isEmpty() || endereco == null || endereco.isEmpty()) {
            return false;
        }
        Remetente remetente = new Remetente(0, nome, cnpj, endereco, telefone);
        return dao.inserir(remetente);
    }
}
