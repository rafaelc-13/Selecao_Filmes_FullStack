package com.apifilmedb.dbfilmes;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/review")
public class ControladorReview {                   //metodo para postar os reviews (form)
    @Autowired
    private ServicoReview servicoReview;

    @PostMapping
    public ResponseEntity<Review> criarReview(@RequestBody @NotNull Map<String, String> payload){
        return new ResponseEntity<Review>(servicoReview.criarReview(payload.get("corpoReview"), payload.get("imdbId")), HttpStatus.CREATED);  //durante o teste, esses end-points são referenciados com a chave e valor Strings
    }
      //o que nós recebermos pelo corpo, nós converteremos para o valor de string.
}
