package br.com.exercicio.apirestcadastro.controller;

import br.com.exercicio.apirestcadastro.Dto.UsuarioDto;
import br.com.exercicio.apirestcadastro.enums.Filtros;
import br.com.exercicio.apirestcadastro.model.CadastroModel;
import br.com.exercicio.apirestcadastro.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class CadastroController {

    @Autowired
    CadastroService cadastroService;

    @Transactional
    @PostMapping("/usuarios/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody List<UsuarioDto> usuariosDto) {
        return cadastroService.cadastrarUsuario(usuariosDto);
    }

    @PutMapping("/usuarios/atualizar")
    public ResponseEntity<?> atualizarUsuario(@RequestBody String identificador, UsuarioDto usuarioDto) {
        return cadastroService.atualizarUsuario(identificador, usuarioDto);
    }

    @DeleteMapping("/usuarios/deletar") //exclusao logica
    public ResponseEntity<?> excluirUsuario(@RequestBody Integer id) {
        return cadastroService.excluirUsuario(id);
    }

    @GetMapping("/usuarios/listar")
    public ResponseEntity<Page<CadastroModel>> listarUsuario(@PageableDefault(size = 10) Pageable pageable) {
        return cadastroService.listarUsuarios(pageable);
    }

    @GetMapping("/lista-paginada")
    public ResponseEntity<?> listaPaginada(@RequestParam Filtros filtros, String valor, Integer paginas, Integer registros) {
        Pageable pageable = PageRequest.of(paginas - 1, registros);
        return cadastroService.listaPaginada(filtros, valor, pageable);
    }

}