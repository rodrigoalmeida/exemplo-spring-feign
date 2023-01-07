package br.com.rodrigoaralmeida.exemplos.springfeign.apirest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PaisesService {
    private List<Pais> paises;
    private static long ultimoId;

    public  PaisesService(){
        popular();
    }

    private void popular(){
        paises = new ArrayList<>();        
        incluir("Brasil");
        incluir("Uruguai");
        incluir("Colômbia");
        incluir("Chile");                
    }

    public List<Pais> obterTodos(){
        return paises;
    }

    public Pais obter(long id){
        var opt = paises.stream()
        .filter(x-> x.getId().equals(id))
       .findFirst();

       if (opt.isEmpty()){
        throw new ServiceException("Pais não encontrado com esse id");
        }

        return opt.get();
    }


    public Pais incluir(String nome){
        PaisesService.ultimoId += 1;
        var pais = new Pais(ultimoId, nome);
        paises.add(pais);
        return pais;
    }

    public Pais atualizar(long id, Pais paisInput){                 
        var pais = obter(id);
        pais.setNome(paisInput.getNome());
        return pais;
    }

    public void excluir(long id){
        var pais = obter(id);
        paises.remove(pais);
    }
    
}
