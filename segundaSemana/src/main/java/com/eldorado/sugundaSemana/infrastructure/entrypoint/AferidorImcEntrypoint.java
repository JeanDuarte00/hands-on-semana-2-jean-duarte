package com.eldorado.sugundaSemana.infrastructure.entrypoint;

import com.eldorado.sugundaSemana.domain.entities.ImcData;
import com.eldorado.sugundaSemana.infrastructure.entrypoint.response.RestfullResponse;
import com.eldorado.sugundaSemana.service.AferidorImcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/imc")
public class AferidorImcEntrypoint {

    @Autowired
    AferidorImcService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity post(@RequestBody ImcData data){
        var result = this.service.save(data);
        var response = new RestfullResponse<ImcData>(result);
        response.setBuscarRecurso("/api/imc/search/"+result.getId());
        response.setDeletarRecurso("/api/imc/delete/"+result.getId());
        response.setAtualizarRecurso("/api/imc/update/"+result.getId());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {
        var result = this.service.getAll();
        List<RestfullResponse> list = new ArrayList<>();
        result.forEach(data -> {

            var response = new RestfullResponse<ImcData>(data);
            response.setBuscarRecurso("/api/imc/search/"+data.getId());
            response.setDeletarRecurso("/api/imc/delete/"+data.getId());
            response.setAtualizarRecurso("/api/imc/update/"+data.getId());

            list.add(response);
        });
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody ImcData data) {
        var result = this.service.update(data);
        var response = new RestfullResponse<ImcData>(result);
        response.setBuscarRecurso("/api/imc/"+result.getId());
        response.setDeletarRecurso("/api/imc/delete/"+result.getId());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable UUID id) {
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

    @GetMapping(value = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getById(@PathVariable UUID id) {
        var result = this.service.getById(id);
        Optional<RestfullResponse> response;
        if(result.isPresent()){
            var data = result.get();
            response = Optional.of(new RestfullResponse<ImcData>(data));
            response.get().setBuscarRecurso("/api/imc/search/"+data.getId());
            response.get().setDeletarRecurso("/api/imc/delete/"+data.getId());
            response.get().setAtualizarRecurso("/api/imc/update/"+data.getId());
        } else {
            response = Optional.empty();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
