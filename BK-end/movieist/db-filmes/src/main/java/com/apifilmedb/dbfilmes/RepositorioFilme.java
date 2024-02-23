package com.apifilmedb.dbfilmes;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //camada responsavel por falar com o banco de dados, e receber os dados
public interface RepositorioFilme extends MongoRepository<Filme, ObjectId> {

    Optional<Filme> findFilmeByImdbId(String imdbId);//uma propriedade que serve como query para achar o filme pelo Id imdb
}
//fala com o banco de dados
