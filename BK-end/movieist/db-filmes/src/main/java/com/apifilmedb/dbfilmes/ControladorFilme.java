package com.apifilmedb.dbfilmes;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/filmes")
public class ControladorFilme {
    @Autowired    //usando a classe de serviço para pegar os filmes do banco de dados e enviar para a camada do API.
    private ServicoFilmes servicoFilmes;
    @GetMapping
    public ResponseEntity<List<Filme>> todosFilmes(){
        return new ResponseEntity<List<Filme>> (servicoFilmes.todosFilmes(), HttpStatus.OK);
    }//recebe a tarefa de retornar todos os filmes da classe de servico para a página principal

    @PutMapping("/{imdbId}")
    public ResponseEntity<Optional<Filme>> atualizarFilme(@PathVariable String imdbId, @RequestBody Filme filme){
        servicoFilmes.atualizarFilme(imdbId,filme);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{imdbId}")
    public ResponseEntity<Optional<Filme>> excluirFilme(@PathVariable String imdbId) {
        servicoFilmes.excluirFilme(imdbId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Filme>> getUnicoFilme(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Filme>>(servicoFilmes.unicoFilme(imdbId), HttpStatus.OK);
    }//retorna cada filme individualmente pelo seu codigo de imdbId, recebidos pela classe de servico
}

//A camada que é o API, é controladora e só vai se importar em pegar um pedido do usuario e retornar uma resposta.
//usando a classe de servicoFilmes, dando a ela o trabalho de pegar todos os fulmes do MongoDB, e faz o return com status HTTP Ok
