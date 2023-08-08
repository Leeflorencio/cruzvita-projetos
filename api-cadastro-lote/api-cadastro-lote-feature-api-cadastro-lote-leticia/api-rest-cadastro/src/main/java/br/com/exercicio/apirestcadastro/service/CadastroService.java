package br.com.exercicio.apirestcadastro.service;

import br.com.exercicio.apirestcadastro.Dto.UsuarioDto;
import br.com.exercicio.apirestcadastro.RetornoCadastro;
import br.com.exercicio.apirestcadastro.enums.Filtros;
import br.com.exercicio.apirestcadastro.enums.Status;
import br.com.exercicio.apirestcadastro.model.CadastroModel;
import br.com.exercicio.apirestcadastro.repository.CadastroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroService {

    @Autowired
    CadastroRepository cadastroRepository;

    @Autowired
    CadastrarUsuario cadastrarUsuario;

    @Autowired
    AtualizarCadastro atualizarCadastro;

    @Autowired
    ExcluirCadastro excluirCadastro;

    @Autowired
    ListarPorFiltro listarPorFiltro;


    public ResponseEntity<?> cadastrarUsuario(List<UsuarioDto> usuariosDto) {
        return cadastrarUsuario.cadastrar(usuariosDto);
    }


    public ResponseEntity<?> atualizarUsuario(String identificador, UsuarioDto usuarioDto) {
        return atualizarCadastro.atualizar(identificador, usuarioDto);
    }

    public ResponseEntity<?> excluirUsuario(Integer id) {
        return excluirCadastro.excluir(id);
    }

    public ResponseEntity<Page<CadastroModel>> listarUsuarios(Pageable pageable) {
        Page<CadastroModel> lista = cadastroRepository.findAll(pageable);
        return ResponseEntity.status(200).body(lista);
    }

    public ResponseEntity<?> listaPaginada(Filtros filtros, String valor, Pageable pageable) {
        return listarPorFiltro.listaEmailStatus(filtros, valor, pageable);
    }

}