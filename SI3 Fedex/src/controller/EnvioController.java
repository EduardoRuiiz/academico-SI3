package controller;

import dao.EnvioDAO;
import java.util.List;
import model.Envio;

// Declaração da classe EnvioController
public class EnvioController {

    // Cria uma instância de EnvioDAO para utilizar os métodos de acesso ao banco
    EnvioDAO envioDAO = new EnvioDAO();

    // Método que retorna uma lista com todos os envios cadastrados
    public List<Envio> listarEnvios() {
        // Chama o método listar da DAO para buscar os envios no banco
        return envioDAO.listar();
    }

    // Método que recebe um objeto Envio e tenta salvá-lo no banco de dados
    public boolean salvarEnvio(Envio envio) {
        // Chama o método inserir da DAO e retorna o resultado da operação
        return envioDAO.inserir(envio);
    }
}
