package br.com.vita.projeto.base.service;

import br.com.vita.projeto.base.dto.ClienteDto;
import br.com.vita.projeto.base.dto.ProdutoDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProdutoRest {

    public ProdutoDto buscarProduto(Long id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/consultar/id/"+ id;
        ResponseEntity<ProdutoDto> response = restTemplate.getForEntity(url, ProdutoDto.class);
        System.out.println(response.getBody());
        return  response.getBody();
    }
}
