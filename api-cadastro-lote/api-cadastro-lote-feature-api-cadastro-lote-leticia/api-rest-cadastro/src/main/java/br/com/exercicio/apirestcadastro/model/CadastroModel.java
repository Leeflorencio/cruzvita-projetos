package br.com.exercicio.apirestcadastro.model;

import br.com.exercicio.apirestcadastro.Dto.UsuarioDto;
import br.com.exercicio.apirestcadastro.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class CadastroModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String nome;
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;


    public void atualizar(UsuarioDto usuarioDto) {
        if( usuarioDto.getNome() != null){
            this.nome = usuarioDto.getNome();
        }
        if( usuarioDto.getEmail() != null){
            this.email = usuarioDto.getEmail();
        }
    }

}