package com.apifilmedb.dbfilmes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "filmes" )  //anotação que representa cada documento da coleção de filmes
@Data                        //vem da biblioteca Lombok cuida dos get & set dos metodos
@AllArgsConstructor          //construtor para considerar a criação de todos os metodos da classe Filme
@NoArgsConstructor
public class Filme {

    @Id                                //avisa ao framework que essa pripriedade deve ser tratada como o identificador de cada filme
    private ObjectId id;               //representa Id do filme
    private String imdbId;             //representa a classificação imdbId do filme
    private String titulo;
    private String dataLancamento;
    private String trailerLink;        //link para o trailer do filme do youtube
    private String poster;             //fotos das capas dos filmes
    private List<String> generos;      //lista importada para aportar todos os generos dos filmes
    private List<String> backdrops;
    @DocumentReference                 //anotação manual do MongoDB, que vai salvar só os Ids das Review, e as Reviews vão ficar numa coleção diferente
    private List<Review> reviewIds;    //embedded = todas as reviews vão para essa lista de cada filme

    // Métodos getters e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
