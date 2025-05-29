package dao;

import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Destinatario;

public class DestinatarioDAO {

    public boolean inserir(Destinatario destinatario) {
        String sql = "INSERT INTO destinatario( nome, cpf, endereco, telefone) VALUES (?,?,?,?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, destinatario.getNome());
            stmt.setString(2, destinatario.getCpf());
            stmt.setString(3, destinatario.getEndereco());
            stmt.setString(4, destinatario.getTelefone());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
