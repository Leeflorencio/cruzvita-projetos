package br.com.exercicio.apirestcadastro.service;

import br.com.exercicio.apirestcadastro.Dto.UsuarioDto;
import br.com.exercicio.apirestcadastro.RetornoCadastro;
import br.com.exercicio.apirestcadastro.model.CadastroModel;
import br.com.exercicio.apirestcadastro.repository.CadastroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class CadastrarUsuario {

    @Autowired
    CadastroRepository cadastroRepository;

    public ResponseEntity<?> cadastrar(List<UsuarioDto> usuariosDto) {
        List<CadastroModel> usuariosCadastrados = new ArrayList<>();
        List<UsuarioDto> usuariosDuplicados = new ArrayList<>();

        for (UsuarioDto usuario : usuariosDto) {
            if (!emailValido(usuario.getEmail())) {
                return ResponseEntity.status(404).body("E-mail inválido.");
            }
            if(!nomeValido(usuario.getNome())){
                 return ResponseEntity.status(404).body("Nome inválido.");
            }
            if (cadastroRepository.existsAllByEmailAndStatus(usuario.getEmail(), usuario.getStatus())) {
                usuariosDuplicados.add(usuario);
            } else {
                CadastroModel cadastroModel = new CadastroModel();
                BeanUtils.copyProperties(usuario, cadastroModel);
                usuariosCadastrados.add(cadastroModel);
                cadastroRepository.save(cadastroModel);
            }
        }
        RetornoCadastro retorno = new RetornoCadastro(usuariosCadastrados, usuariosDuplicados);
        Integer quantidadeCadastro = retorno.getUsuariosCadastrados().size();

        //finalizar o retorno com a quantidade de usuarios cadastrados
        return ResponseEntity.status(200).body(retorno);
    }

    private boolean emailValido(String email) {
        String regex = "^[A-Za-z0-9_.+-]+@(gmail|hotmail|yahoo|outlook|email)\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex, email);
    }

    private boolean nomeValido(String nome){
        String regex = "[A-Za-z]*";
        return  Pattern.matches(regex, nome);
    }
}

