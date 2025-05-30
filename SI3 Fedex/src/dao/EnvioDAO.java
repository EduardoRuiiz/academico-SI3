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

public class EnvioDAO {

    public boolean inserir(Envio envio) {
        String sql = "INSERT INTO ENVIO (remetente_id, destinatario_id, tipo_entrega, peso, data_envio, codigo_rastreamento, status_atual) VALUE (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, envio.getRemetente().getId());
            stmt.setInt(2, envio.getDestinatario().getId());
            stmt.setString(3, envio.getTipoEntrega().toString());
            stmt.setBigDecimal(4, envio.getPeso());
            stmt.setDate(5, envio.getDataEnvio());
            stmt.setString(6, envio.getCodigoRastreamento());
            stmt.setString(7, envio.getStatus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Envio> listar() {
        List<Envio> envios = new ArrayList<>();

        String sql = "SELECT e.codigo_rastreamento, e.tipo_entrega, e.peso, e.data_envio, e.status_atual, "
                + "r.id AS remetente_id, r.nome AS remetente_nome, r.cnpj AS remetente_cnpj, "
                + "r.endereco AS remetente_endereco, r.telefone AS remetente_telefone, "
                + "d.id AS destinatario_id, d.nome AS destinatario_nome, d.cpf AS destinatario_cpf, "
                + "d.endereco AS destinatario_endereco, d.telefone AS destinatario_telefone "
                + "FROM envio e "
                + "JOIN remetente r ON e.remetente_id = r.id "
                + "JOIN destinatario d ON e.destinatario_id = d.id";

        try (Connection con = Conexao.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Remetente remetente = new Remetente(
                        rs.getInt("remetente_id"),
                        rs.getString("remetente_nome"),
                        rs.getString("remetente_cnpj"),
                        rs.getString("remetente_endereco"),
                        rs.getString("remetente_telefone")
                );
                Destinatario destinatario = new Destinatario(
                        rs.getInt("destinatario_id"),
                        rs.getString("destinatario_nome"),
                        rs.getString("destinatario_cpf"),
                        rs.getString("destinatario_endereco"),
                        rs.getString("destinatario_telefone")
                );

                TipoEntrega tipoEntrega = rs.getString("tipo_entrega").equalsIgnoreCase("AEREO")
                        ? TipoEntrega.AEREO
                        : TipoEntrega.RODOVIARIO;

                Envio envio = new Envio(
                        rs.getString("codigo_rastreamento"),
                        destinatario,
                        remetente,
                        tipoEntrega,
                        rs.getBigDecimal("peso"),
                        rs.getDate("data_envio"),
                        rs.getString("status_atual")
                );

                envios.add(envio);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return envios;
    }

}
