package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // URL da conexão JDBC com o banco MySQL, incluindo porta e nome do banco
    private static final String URL = "jdbc:mysql://localhost:3306/fedexx";
    // Usuário do banco de dados
    private static final String USER = "root";
    // Senha do banco de dados
    private static final String PASSWORD = "admin";

    // Método que retorna uma conexão ativa com o banco
    public static Connection getConnection() {
        try {
            // Registra o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Abre e retorna a conexão com o banco
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // Imprime erro caso falhe ao carregar driver ou abrir conexão
            e.printStackTrace();
            return null; // Retorna null se não conseguir conectar
        }
    }

    // Método para fechar a conexão, se estiver aberta
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close(); // Fecha a conexão
            }
        } catch (SQLException e) {
            // Imprime erro caso falhe ao fechar conexão
            e.printStackTrace();
        }
    }
}
