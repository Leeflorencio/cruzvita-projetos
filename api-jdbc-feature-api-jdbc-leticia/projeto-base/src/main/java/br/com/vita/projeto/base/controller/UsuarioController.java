package br.com.vita.projeto.base.controller;

import br.com.vita.projeto.base.dto.Usuario;
import br.com.vita.projeto.base.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public String cadastro(@RequestBody Usuario usuario){
       return usuarioService.cadastro(usuario);
    }

    @GetMapping("/consultarUsuario")
    public ResponseEntity<?> consultar(@RequestParam String cpf) {
        Usuario usuario = usuarioService.consultar(cpf);

        if(usuario.getCpf() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não localizado");
        }else{
            return  ResponseEntity.ok(usuario);
        }
    }
}