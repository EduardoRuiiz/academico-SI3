package controller;

import dao.EnvioDAO;
import java.util.List;
import model.Envio;

public class EnvioController {

    EnvioDAO envioDAO = new EnvioDAO();

    public List<Envio> listarEnvios() {
        return envioDAO.listar();
    }

    public boolean salvarEnvio(Envio envio) {
        return envioDAO.inserir(envio);
    }
}
