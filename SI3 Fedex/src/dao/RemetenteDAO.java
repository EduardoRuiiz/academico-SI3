package dao;

import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Remetente;

public class RemetenteDAO {

    public boolean inserir(Remetente remetente) {
        String sql = "INSERT INTO remetente (nome, cnpj, endereco, telefone) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, remetente.getNome());
            stmt.setString(2, remetente.getCnpj());
            stmt.setString(3, remetente.getEndereco());
            stmt.setString(4, remetente.getTelefone());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Remetente> listarRemetentes() {
        List<Remetente> lista = new ArrayList();
        String sql = "SELECT * FROM remetente";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Remetente r = new Remetente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cnpj"),
                        rs.getString("endereco"),
                        rs.getString("telefone")
                );
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
