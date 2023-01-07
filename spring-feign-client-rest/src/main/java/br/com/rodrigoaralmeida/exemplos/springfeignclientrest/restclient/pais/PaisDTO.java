package br.com.rodrigoaralmeida.exemplos.springfeignclientrest.restclient.pais;

import org.springframework.boot.jackson.JsonComponent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaisDTO{
    
    private Long id;
    private String nome;   
}

