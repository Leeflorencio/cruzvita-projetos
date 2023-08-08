package br.com.exercicio.apirestcadastro.service;

import br.com.exercicio.apirestcadastro.Dto.PedidoDto;
import br.com.exercicio.apirestcadastro.Dto.UsuarioDto;
import br.com.exercicio.apirestcadastro.Respostas;
import br.com.exercicio.apirestcadastro.enums.Filtros;
import br.com.exercicio.apirestcadastro.enums.Status;
import br.com.exercicio.apirestcadastro.model.CadastroModel;
import br.com.exercicio.apirestcadastro.model.PedidoModel;
import br.com.exercicio.apirestcadastro.repository.CadastroRepository;
import br.com.exercicio.apirestcadastro.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    CadastroRepository cadastroRepository;

    @Autowired
    CadastrarPedido cadastrarPedido;

    @Autowired
    AtualizarPedido atualizarPedido;

    @Autowired
    ExcluirPedido excluirPedido;

    @Autowired
    ListarPedidoPorFiltro listarPedidoPorFiltro;


    public ResponseEntity<?> gerarPedido(PedidoDto pedidoDto) {
        return cadastrarPedido.realizarPedido(pedidoDto);
    }

    public ResponseEntity<?> atualizarPedido(String id, PedidoDto pedidoDto) {
        return atualizarPedido.atualizar(id, pedidoDto);
    }

    public ResponseEntity<?> excluirPedido(String id) {
        return excluirPedido.excluir(id);
    }

    public ResponseEntity<Page<PedidoModel>> listarPedidos(Pageable pageable) {
        Page<PedidoModel> lista = pedidoRepository.findAll(pageable);
        return ResponseEntity.status(200).body(lista);
    }

    public ResponseEntity<?> listarPorId(Pageable pageable, Integer id) {
        return listarPedidoPorFiltro.listar(pageable, id);
    }
}
