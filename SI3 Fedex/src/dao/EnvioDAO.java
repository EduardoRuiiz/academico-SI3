package dao;

import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Destinatario;
import model.Envio;
import model.Remetente;
import model.TipoEntrega;

// Classe responsável por operações de banco de dados relacionadas a "Envio"
public class EnvioDAO {

    // Método para inserir um novo envio no banco de dados
    public boolean inserir(Envio envio) {
        // Comando SQL com placeholders para inserção de dados
        String sql = "INSERT INTO ENVIO (remetente_id, destinatario_id, tipo_entrega, peso, data_envio, codigo_rastreamento, status_atual) VALUE (?, ?, ?, ?, ?, ?, ?)";

        // Bloco try-with-resources para garantir fechamento da conexão e do statement
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Preenche os parâmetros do SQL com os dados do objeto Envio
            stmt.setInt(1, envio.getRemetente().getId());
            stmt.setInt(2, envio.getDestinatario().getId());
            stmt.setString(3, envio.getTipoEntrega().toString());
            stmt.setBigDecimal(4, envio.getPeso());
            stmt.setDate(5, envio.getDataEnvio());
            stmt.setString(6, envio.getCodigoRastreamento());
            stmt.setString(7, envio.getStatus());

            // Executa o comando SQL
            stmt.executeUpdate();
            return true; // Retorna true se a inserção for bem-sucedida

        } catch (SQLException e) {
            // Em caso de erro, imprime a stack trace no console
            e.printStackTrace();
            return false; // Retorna false se houver erro na inserção
        }
    }

    // Método que retorna uma lista com todos os envios cadastrados no banco
    public List<Envio> listar() {
        // Lista onde os envios serão armazenados
        List<Envio> envios = new ArrayList<>();

        // Consulta SQL com JOINs para obter os dados de envio, remetente e destinatário
        String sql = "SELECT e.codigo_rastreamento, e.tipo_entrega, e.peso, e.data_envio, e.status_atual, "
                + "r.id AS remetente_id, r.nome AS remetente_nome, r.cnpj AS remetente_cnpj, "
                + "r.endereco AS remetente_endereco, r.telefone AS remetente_telefone, "
                + "d.id AS destinatario_id, d.nome AS destinatario_nome, d.cpf AS destinatario_cpf, "
                + "d.endereco AS destinatario_endereco, d.telefone AS destinatario_telefone "
                + "FROM envio e "
                + "JOIN remetente r ON e.remetente_id = r.id "
                + "JOIN destinatario d ON e.destinatario_id = d.id";

        // Bloco try para executar a consulta e montar os objetos
        try (Connection con = Conexao.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            // Percorre o resultado da consulta
            while (rs.next()) {
                // Cria objeto Remetente com os dados vindos do banco
                Remetente remetente = new Remetente(
                        rs.getInt("remetente_id"),
                        rs.getString("remetente_nome"),
                        rs.getString("remetente_cnpj"),
                        rs.getString("remetente_endereco"),
                        rs.getString("remetente_telefone")
                );

                // Cria objeto Destinatario com os dados do banco
                Destinatario destinatario = new Destinatario(
                        rs.getInt("destinatario_id"),
                        rs.getString("destinatario_nome"),
                        rs.getString("destinatario_cpf"),
                        rs.getString("destinatario_endereco"),
                        rs.getString("destinatario_telefone")
                );

                // Converte a string do tipo de entrega para o enum correspondente
                TipoEntrega tipoEntrega = rs.getString("tipo_entrega").equalsIgnoreCase("AEREO")
                        ? TipoEntrega.AEREO
                        : TipoEntrega.RODOVIARIO;

                // Cria o objeto Envio com todos os dados lidos
                Envio envio = new Envio(
                        rs.getString("codigo_rastreamento"),
                        destinatario,
                        remetente,
                        tipoEntrega,
                        rs.getBigDecimal("peso"),
                        rs.getDate("data_envio"),
                        rs.getString("status_atual")
                );

                // Adiciona o envio à lista
                envios.add(envio);
            }

        } catch (SQLException ex) {
            // Em caso de erro, imprime a stack trace
            ex.printStackTrace();
        }

        // Retorna a lista de envios
        return envios;
    }
}
