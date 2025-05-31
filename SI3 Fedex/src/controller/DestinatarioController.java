package controller;

import dao.DestinatarioDAO;
import model.Destinatario;

// Declara a classe DestinatarioController
public class DestinatarioController {

    // Cria uma instância da classe DestinatarioDAO para acesso ao banco de dados
    private DestinatarioDAO dao = new DestinatarioDAO();

    // Método público que tenta cadastrar um novo destinatário e retorna true se for bem-sucedido
    public boolean cadastrar(String nome, String cpf, String endereco, String telefone) {
        // Verifica se algum dos campos obrigatórios está nulo ou vazio
        if (nome == null || nome.isEmpty()
                || endereco == null || endereco.isEmpty()
                || telefone == null || telefone.isEmpty()
                || cpf == null || cpf.isEmpty()) {
            return false; // Retorna false se qualquer campo obrigatório estiver inválido
        }

        // Cria um novo objeto Destinatario com os dados informados
        // O valor 0 pode indicar que o ID será gerado automaticamente pelo banco
        Destinatario destinatario = new Destinatario(0, nome, cpf, endereco, telefone);

        // Chama o método inserir da DAO para salvar o destinatário no banco de dados
        return dao.inserir(destinatario);
    }
}
