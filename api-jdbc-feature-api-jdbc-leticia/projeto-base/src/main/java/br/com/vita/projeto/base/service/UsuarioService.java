package br.com.vita.projeto.base.service;

import br.com.vita.projeto.base.ConexaoFactory;
import br.com.vita.projeto.base.dto.Usuario;
import br.com.vita.projeto.base.repository.UsuarioDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.SQLException;

@Service
public class UsuarioService {
    private ConexaoFactory connection;

    public UsuarioService() {
        this.connection = new ConexaoFactory();
    }

    public String cadastro(Usuario usuario) {
        Connection conn = connection.recuperarConexao();
        String result = String.valueOf(new UsuarioDAO(conn).consultar(usuario.getCpf()));
        if (new UsuarioDAO(conn).consultar(usuario.getCpf()).getCpf() != null) {
            return "Usuario localizado no sistema";
        } else {
            new UsuarioDAO(conn).cadastro(usuario);
            return "Usuario cadastrado com sucesso";
        }
    }

    public Usuario consultar(@RequestParam String cpf){
        Usuario result = null;
        Connection conn = connection.recuperarConexao();
        result = new UsuarioDAO(conn).consultar(cpf);
        return result;
    }
}