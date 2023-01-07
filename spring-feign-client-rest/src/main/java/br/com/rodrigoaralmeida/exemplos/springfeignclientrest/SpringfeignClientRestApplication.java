package br.com.rodrigoaralmeida.exemplos.springfeignclientrest;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.rodrigoaralmeida.exemplos.springfeignclientrest.restclient.pais.PaisDTO;
import br.com.rodrigoaralmeida.exemplos.springfeignclientrest.restclient.pais.PaisApiRestClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class SpringfeignClientRestApplication implements CommandLineRunner {

	@Autowired
	private PaisApiRestClient paisProxy;

	public static void main(String[] args) {
		SpringApplication.run(SpringfeignClientRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var pais = paisProxy.get(1L);
		log.debug("Pais 1: {}", pais);

		listarPaises();

		log.debug("-- post pais teste -- ");
		pais =  PaisDTO.builder()
				.nome("teste")
				.build();
		
		pais = paisProxy.post(pais);
		log.debug("pais criado: {}", pais);

		listarPaises();

		log.debug("-- post pais teste -- ");
		pais.setNome("teste atualizado");

		listarPaises();
		
		pais = paisProxy.put(pais.getId(),pais);
		log.debug("pais atualizado: {}", pais);		

		listarPaises();

		paisProxy.delete(pais.getId());
		log.debug("pais excluido: {}", pais);		

		listarPaises();
	}

	private void listarPaises(){
		log.debug("-- Paises --");
		var paises = paisProxy.get("Brasil");
		paises.stream().forEach(x -> log.debug(" - {}", x));

	}

}
