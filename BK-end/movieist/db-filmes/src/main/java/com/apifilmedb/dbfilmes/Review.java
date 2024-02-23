package com.apifilmedb.dbfilmes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews") //anotação que representa cada documento da coleção de reviews
@Data                             //vem da biblioteca Lombok cuida dos get & set dos metodos
@AllArgsConstructor               //construtor para considerar a criação de todos os metodos da classe Filme
@NoArgsConstructor
public class Review {

    @Id
    private String Id;             //avisa ao framework que essa pripriedade deve ser tratada como o identificador de cada review
    private String corpo;
    public Review(String corpo) {

        this.corpo = corpo;
    }
}
