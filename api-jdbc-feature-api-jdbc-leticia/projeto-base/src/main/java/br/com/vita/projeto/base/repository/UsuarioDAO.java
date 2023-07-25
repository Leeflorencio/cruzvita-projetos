package br.com.vita.projeto.base.repository;
import br.com.vita.projeto.base.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    @Autowired
    Usuario usuario;
    private Connection conn;

    public UsuarioDAO(Connection connection){
        this.conn = connection;
    }

    public void cadastro(Usuario usuario){
        //String resultado = null;
        String sql = "INSERT INTO usuario (nome, cpf, email, telefone, endereco)" +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getCpf());
            preparedStatement.setString(3, usuario.getEmail());
            preparedStatement.setString(4, usuario.getTelefone());
            preparedStatement.setString(5, usuario.getEndereco());

            preparedStatement.execute();
            preparedStatement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario consultar(String cpf){
        String sql = "SELECT * FROM usuario WHERE cpf = ?";
        ResultSet resultSet;
        Usuario usuario = new Usuario();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, cpf);
            resultSet = preparedStatement.executeQuery();

            if(resultSet == null ){
                return usuario = null;
            }
            while(resultSet.next()){
                String dados = resultSet.getString(1);
                System.out.println(dados);
                    usuario.setId(resultSet.getLong(1));
                    usuario.setNome(resultSet.getString(2));
                    usuario.setCpf(resultSet.getString(3));
                    usuario.setEmail(resultSet.getString(4));
                    usuario.setTelefone(resultSet.getString(5));
                    usuario.setEndereco(resultSet.getString(6));
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}
