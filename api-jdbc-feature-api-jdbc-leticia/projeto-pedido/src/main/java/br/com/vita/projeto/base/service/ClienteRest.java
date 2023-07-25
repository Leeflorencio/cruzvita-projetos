package br.com.vita.projeto.base.service;

import br.com.vita.projeto.base.dto.ClienteDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClienteRest {
    public ClienteDto buscarCliente(String cpf) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/consultarUsuario?cpf="+ cpf;
        ResponseEntity<ClienteDto> response = restTemplate.getForEntity(url, ClienteDto.class);

        System.out.println(response.getBody());
        return response.getBody();
    }
}
