package br.com.exercicio.apirestcadastro.service;

import br.com.exercicio.apirestcadastro.enums.Status;
import br.com.exercicio.apirestcadastro.model.CadastroModel;
import br.com.exercicio.apirestcadastro.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExcluirCadastro {

    @Autowired
    CadastroRepository cadastroRepository;

    public ResponseEntity<?> excluir(Integer id) {
        CadastroModel usuario = cadastroRepository.getReferenceById(id);
        if(cadastroRepository.existsById(id) && usuario.getStatus() == Status.ATIVO){
            usuario.setStatus(Status.INATIVO);
            cadastroRepository.save(usuario);
            return ResponseEntity.status(200).body("Usuário excluído com sucesso");
        }
        return ResponseEntity.status(400).body("Usuário não cadastrado no sistema");
    }
}
