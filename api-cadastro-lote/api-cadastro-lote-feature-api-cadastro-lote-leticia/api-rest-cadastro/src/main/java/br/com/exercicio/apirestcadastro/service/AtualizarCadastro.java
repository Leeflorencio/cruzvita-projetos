package br.com.exercicio.apirestcadastro.service;

import br.com.exercicio.apirestcadastro.Dto.UsuarioDto;
import br.com.exercicio.apirestcadastro.model.CadastroModel;
import br.com.exercicio.apirestcadastro.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AtualizarCadastro {

    @Autowired
    CadastroRepository cadastroRepository;

    public ResponseEntity<?> atualizar(String id, UsuarioDto usuarioDto) {
        try {
            Integer identificador = Integer.parseInt(id);

            CadastroModel usuario = cadastroRepository.getReferenceById(identificador);
            if (!cadastroRepository.existsById(identificador)) {
                return ResponseEntity.status(400).body("Usuário não cadastrado no sistema");
            } else {
                usuario.atualizar(usuarioDto);
                cadastroRepository.save(usuario);
                return ResponseEntity.status(200).body("Dados atualizados com sucesso");
            }

        } catch (NumberFormatException e) {
            return ResponseEntity.status(400).body("ID inválido. Forneça apenas números.");
        }
    }
}