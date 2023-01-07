package br.com.rodrigoaralmeida.exemplos.springfeignclientrest.restclient.pais;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="pais-service", url="${app.client.pais.url}")
public interface PaisApiRestClient {
    
    @GetMapping("/api/paises")
    public List<PaisDTO> get(@RequestParam(required = false) String nome);

    @GetMapping("/api/paises/{id}")
    public PaisDTO get(@PathVariable Long id);

    @PostMapping("/api/paises")
    public PaisDTO post(@RequestBody PaisDTO pais);

    @PutMapping("/api/paises/{id}")
    public PaisDTO put(@PathVariable long id, @RequestBody PaisDTO pais);

    @DeleteMapping("/api/paises/{id}")
    public void delete(@PathVariable long id);
}
