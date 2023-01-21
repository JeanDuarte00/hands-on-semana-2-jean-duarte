package com.eldorado.sugundaSemana.infrastructure.entrypoint;

import com.eldorado.sugundaSemana.domain.entities.ImcData;
import com.eldorado.sugundaSemana.domain.entities.classificadorImc.WeightClassifier;
import com.eldorado.sugundaSemana.usecase.ClassifierUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aferir")
public class AferidorImc {

    @Autowired
    ClassifierUseCase classificador;
    @PostMapping(value = "/imc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity postAferirImc(@RequestBody ImcData data){
        var result = classificador.classify(data);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
