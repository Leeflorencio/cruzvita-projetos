package br.com.vita.projeto.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    public Connection recuperarConexao() {
        try {
            return DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1:3306/produto?user=root&password=root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
