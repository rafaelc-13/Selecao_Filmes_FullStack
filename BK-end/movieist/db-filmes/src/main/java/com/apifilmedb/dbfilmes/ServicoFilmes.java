package com.apifilmedb.dbfilmes;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service                                                //classes para acessar o bd
public class ServicoFilmes {
    @Autowired
    private RepositorioFilme repositorioFilme;          //recebe e retorna os filmes do repositorio.
    public List<Filme> todosFilmes(){                  //get.retorna a lista de filmes para o gontrolador
        return repositorioFilme.findAll();              //find.all = metodo descrito na classe MongoRepository
    }
    public void atualizarFilme(String imdbId, Filme filme) {
        Optional<Filme> optionalFilme = repositorioFilme.findFilmeByImdbId(imdbId);
        if (optionalFilme.isPresent()) {
            Filme filmeExistente = optionalFilme.get();                  // Atualizar os atributos do filmeExistente com os atributos do filme recebido
            filmeExistente.setTitulo(filme.getTitulo());                 // Salva as alterações no banco de dados
            filmeExistente.setDataLancamento(filme.getDataLancamento()); // Atualize outros detalhes do filme conforme necessário
            repositorioFilme.save(filmeExistente);
        }
    }

    public void excluirFilme(String imdbId) {
        Optional<Filme> optionalFilme = repositorioFilme.findFilmeByImdbId(imdbId);
        optionalFilme.ifPresent(repositorioFilme::delete);
    }

    public Optional<Filme> unicoFilme(String imdbId){            //retorna filme unico para o controlador
        return repositorioFilme.findFilmeByImdbId(imdbId);
    }//get filme unico pelo imdbId individual.
}
