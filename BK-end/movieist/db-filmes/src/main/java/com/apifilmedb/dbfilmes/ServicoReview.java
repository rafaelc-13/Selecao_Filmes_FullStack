package com.apifilmedb.dbfilmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ServicoReview {
    @Autowired
    private RepositorioReview repositorioReview;                  //criando um repositorio dos reviews no filme para inserir no bd
    @Autowired
    private MongoTemplate mongoTemplate;                          //associando os reviews com o banco de dados do filme fazedo um Query Dincamico

    public Review criarReview(String corpoReview, String imdbId){                     //referindo o imdbId do site ao do banco de dados
        Review review = repositorioReview.insert(new Review(corpoReview));           //cria nova review no banco de dados, insert retorna o dado pushado no banco de dados

        mongoTemplate.update(Filme.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;                                    //usa um template para fazer o update na classe filme com a review nova

        //usando o template para fazer uma call de update na classe de filmes e preencher
        // fazer o push do novo review no array vazio

    }
}
