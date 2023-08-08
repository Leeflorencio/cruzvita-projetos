package br.com.exercicio.apirestcadastro;
import br.com.exercicio.apirestcadastro.Dto.UsuarioDto;
import br.com.exercicio.apirestcadastro.model.CadastroModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RetornoCadastro {
 List<CadastroModel> usuariosCadastrados;
 List<UsuarioDto> usuariosDuplicados;
}
