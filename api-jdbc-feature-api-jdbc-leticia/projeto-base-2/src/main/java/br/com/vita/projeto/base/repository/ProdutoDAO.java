package br.com.vita.projeto.base.repository;

import br.com.vita.projeto.base.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {
    @Autowired
    ProdutoDTO produtoDTO;
    private Connection conn;

    public ProdutoDAO(Connection connection){
        this.conn = connection;
    }

    public void cadastroProduto(ProdutoDTO produtoDTO){
        //String resultado = null;
        String sql = "INSERT INTO produtos (nome, descricao, preco, qdtEstoque)" +
                "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, produtoDTO.getNome());
            preparedStatement.setString(2, produtoDTO.getDescricao());
            preparedStatement.setDouble(3, produtoDTO.getPreco());
            preparedStatement.setInt(4, produtoDTO.getQdtEstoque());

            preparedStatement.execute();
            preparedStatement.close();
            conn.close();
            //resultado = "Cadastro realizado com sucesso!";

    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ProdutoDTO consultarProduto(String nome){
        String sql = "SELECT * FROM produtos WHERE nome = ?";
        ResultSet resultSet;
        ProdutoDTO produto = new ProdutoDTO();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            resultSet = preparedStatement.executeQuery();

            if(resultSet == null ){
                return produto = null;
            }

            while(resultSet.next()){
                    String nomeProduto = resultSet.getString(1);
                    System.out.println(nomeProduto);

                    produto.setNome(resultSet.getString(2));
                    produto.setDescricao(resultSet.getString(3));
                    produto.setPreco(resultSet.getDouble(4));
                    produto.setQdtEstoque(resultSet.getInt(5));
                }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        return produto;
    }

    public ProdutoDTO consultarId(Long id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        ResultSet resultSet;
        ProdutoDTO produto = new ProdutoDTO();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet == null ){
                return produto = null;
            }

            while(resultSet.next()){
                String nomeProduto = resultSet.getString(1);
                System.out.println(nomeProduto);

                produto.setId(resultSet.getLong(1));
                produto.setNome(resultSet.getString(2));
                produto.setDescricao(resultSet.getString(3));
                produto.setPreco(resultSet.getDouble(4));
                produto.setQdtEstoque(resultSet.getInt(5));
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        return produto;
    }
}
