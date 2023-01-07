package br.com.rodrigoaralmeida.exemplos.springfeign.apirest;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/paises")
public class PaisesApiController {

    private PaisesService paisesService;

    PaisesApiController(PaisesService paisesService){
        this.paisesService = paisesService;        
    }   

    @GetMapping
    public List<Pais> get(@RequestParam(required = false) String nome){
        return paisesService.obterTodos();
    }

    @GetMapping("{id}")
    public Pais get(@PathVariable long id){
        return paisesService.obter(id);
    }

    @PostMapping
    public Pais post(@RequestBody Pais pais){
        return paisesService.incluir(pais.getNome());
    }

    @PutMapping("{id}")
    public Pais put(@PathVariable long id, @RequestBody Pais pais){
        return paisesService.atualizar(id, pais);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        paisesService.excluir(id);
    }
    
}
