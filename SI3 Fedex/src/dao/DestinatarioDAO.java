package dao;

import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Destinatario;

// Classe responsável por executar operações de banco de dados relacionadas a destinatários
public class DestinatarioDAO {

    // Método para inserir um novo destinatário no banco de dados
    public boolean inserir(Destinatario destinatario) {
        // Comando SQL com parâmetros (placeholders ?)
        String sql = "INSERT INTO destinatario (nome, cpf, endereco, telefone) VALUES (?,?,?,?)";

        // Bloco try-with-resources para garantir que a conexão e o statement sejam fechados automaticamente
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define os valores dos parâmetros da consulta SQL com os dados do destinatário
            stmt.setString(1, destinatario.getNome());
            stmt.setString(2, destinatario.getCpf());
            stmt.setString(3, destinatario.getEndereco());
            stmt.setString(4, destinatario.getTelefone());

            // Executa a instrução de inserção no banco
            stmt.executeUpdate();

            // Retorna true indicando que a inserção foi bem-sucedida
            return true;
        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace no console
            e.printStackTrace();

            // Retorna false indicando falha na inserção
            return false;
        }
    }

    // Método para listar todos os destinatários cadastrados no banco
    public List<Destinatario> listarDestinatarios() {
        // Cria uma lista para armazenar os destinatários recuperados
        List<Destinatario> lista = new ArrayList<>();

        // Comando SQL para selecionar todos os registros da tabela destinatario
        String sql = "SELECT * FROM destinatario";

        // Bloco try-with-resources para abrir conexão, preparar statement e executar a consulta
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            // Percorre os resultados retornados pelo banco
            while (rs.next()) {
                // Cria um objeto Destinatario com os dados do resultado atual
                Destinatario d = new Destinatario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("endereco"),
                        rs.getString("telefone")
                );

                // Adiciona o destinatário à lista
                lista.add(d);
            }
        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace no console
            e.printStackTrace();
        }

        // Retorna a lista de destinatários
        return lista;
    }
}
