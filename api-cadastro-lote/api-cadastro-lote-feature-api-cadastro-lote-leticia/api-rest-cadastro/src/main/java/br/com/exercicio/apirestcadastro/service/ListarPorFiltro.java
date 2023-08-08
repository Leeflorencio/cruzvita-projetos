package br.com.exercicio.apirestcadastro.service;

import br.com.exercicio.apirestcadastro.Respostas;
import br.com.exercicio.apirestcadastro.enums.Filtros;
import br.com.exercicio.apirestcadastro.enums.Status;
import br.com.exercicio.apirestcadastro.model.CadastroModel;
import br.com.exercicio.apirestcadastro.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ListarPorFiltro {

    @Autowired
    CadastroRepository cadastroRepository;

    public ResponseEntity<?> listaEmailStatus(Filtros filtros, String valor, Pageable pageable) {

        if (filtros.equals(Filtros.EMAIL)) {
            if (!emailValido(valor)) {
                return ResponseEntity.status(404).body("Informe um e-mail válido");
            }
            Page<CadastroModel> email = cadastroRepository.findByEmail(valor, pageable);
            return ResponseEntity.status(200).body(email);
        }
        if (filtros.equals(Filtros.STATUS)) {
            try {
                Page<CadastroModel> status = cadastroRepository.findByStatus(Status.valueOf(valor.toUpperCase()), pageable);
                return ResponseEntity.status(200).body(status);

            } catch (NullPointerException e) {
                return ResponseEntity.status(404).body("Escreva as opções de status corretamente: ATIVO ou INATIVO");
            }
        }
        return null;
    }

    private boolean emailValido(String email) {
        String regex = "^[A-Za-z0-9_.+-]+@(gmail|hotmail|yahoo|outlook|email)\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex, email);
    }
}
