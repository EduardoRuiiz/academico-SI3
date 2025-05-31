package controller;

import dao.RemetenteDAO;
import model.Remetente;

// Declaração da classe RemetenteController (controlador responsável pela lógica de negócio relacionada a Remetentes)
public class RemetenteController {

    // Cria uma instância da classe RemetenteDAO para interagir com o banco de dados
    private RemetenteDAO dao = new RemetenteDAO();

    // Método para cadastrar um remetente com os dados informados
    public boolean cadastrar(String nome, String cnpj, String endereco, String telefone) {
        // Verifica se os campos obrigatórios nome e endereço estão nulos ou vazios
        if (nome == null || nome.isEmpty() || endereco == null || endereco.isEmpty()) {
            return false; // Retorna false se qualquer um dos campos obrigatórios estiver inválido
        }

        // Cria um novo objeto Remetente com os dados recebidos
        // O ID é definido como 0, geralmente indicando que será gerado automaticamente no banco
        Remetente remetente = new Remetente(0, nome, cnpj, endereco, telefone);

        // Chama o método inserir da DAO para salvar o remetente no banco de dados e retorna o resultado
        return dao.inserir(remetente);
    }
}
