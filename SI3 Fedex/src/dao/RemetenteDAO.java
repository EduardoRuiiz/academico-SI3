package dao;

import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Remetente;

// Classe responsável pelas operações de banco de dados relacionadas ao remetente
public class RemetenteDAO {

    // Método para inserir um remetente no banco de dados
    public boolean inserir(Remetente remetente) {
        // Comando SQL com placeholders para inserção de dados
        String sql = "INSERT INTO remetente (nome, cnpj, endereco, telefone) VALUES (?, ?, ?, ?)";

        // Bloco try-with-resources para garantir o fechamento da conexão e do statement automaticamente
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define os valores dos parâmetros da query com os dados do objeto remetente
            stmt.setString(1, remetente.getNome());
            stmt.setString(2, remetente.getCnpj());
            stmt.setString(3, remetente.getEndereco());
            stmt.setString(4, remetente.getTelefone());

            // Executa o comando de inserção
            stmt.executeUpdate();
            return true; // Retorna true se a inserção for bem-sucedida

        } catch (SQLException e) {
            // Imprime o erro no console se ocorrer uma exceção
            e.printStackTrace();
            return false; // Retorna false se houver falha
        }
    }

    // Método para listar todos os remetentes cadastrados no banco
    public List<Remetente> listarRemetentes() {
        // Cria uma lista para armazenar os remetentes retornados
        List<Remetente> lista = new ArrayList();

        // Comando SQL para selecionar todos os dados da tabela remetente
        String sql = "SELECT * FROM remetente";

        // Bloco try com conexão, preparedStatement e resultSet
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            // Percorre o resultado da consulta
            while (rs.next()) {
                // Cria um objeto Remetente com os dados do banco
                Remetente r = new Remetente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cnpj"),
                        rs.getString("endereco"),
                        rs.getString("telefone")
                );

                // Adiciona o remetente à lista
                lista.add(r);
            }
        } catch (SQLException e) {
            // Imprime erro no console caso ocorra exceção
            e.printStackTrace();
        }

        // Retorna a lista de remetentes
        return lista;
    }
}
