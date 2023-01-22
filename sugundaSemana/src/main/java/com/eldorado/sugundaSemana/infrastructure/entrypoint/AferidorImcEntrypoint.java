package com.eldorado.sugundaSemana.infrastructure.entrypoint;

import com.eldorado.sugundaSemana.domain.entities.ImcData;
import com.eldorado.sugundaSemana.infrastructure.service.ClassifierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aferir/imc")
@Slf4j
@RequiredArgsConstructor
public class AferidorImc {

    @Autowired
    ClassifierService classificador;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity postAferirImc(@RequestBody ImcData data){
        var result = classificador.classify(data);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public void getImcList() {
        log.warn("Not Implemented");
    }

    @PutMapping("/{imcId}")
    public void updateImc(@PathVariable UUID imcId) {
        log.warn("Not Implemented", imcId);
    }

    @DeleteMapping("/{imcId}")
    public void deleteImc(@PathVariable UUID imcId) {
        log.warn("Not Implemented", imcId);
    }

    @GetMapping("/{imcId}")
    public void getImc(@PathVariable UUID imcId) {
        log.warn("Not Implemented", imcId);
    }
}
