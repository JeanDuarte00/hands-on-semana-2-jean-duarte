package com.eldorado.sugundaSemana.service;

import com.eldorado.sugundaSemana.domain.entities.ImcData;
import com.eldorado.sugundaSemana.infrastructure.repository.ImcDataRepository;
import com.eldorado.sugundaSemana.usecase.ClassifierUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
@AllArgsConstructor
public class AferidorImcService {

    @Autowired
    ClassifierUseCase classifierService;

    @Autowired
    ImcDataRepository repository;

    public ImcData save (ImcData data){
        data.setId(UUID.randomUUID());
        var imcClassificado = this.classifierService.classify(data);
        var result =  this.repository.insert(imcClassificado);
        return result;
    }

    public List<ImcData> getAll(){
        return this.repository.findAll();
    }

    public Optional<ImcData> getById(UUID id){
        return this.repository.findById(id);
    }

    public void delete(UUID id){
        this.repository.deleteById(id);
    }

    public ImcData update(ImcData data){
        var imcClassificado = this.classifierService.classify(data);
        var result =  this.repository.save(imcClassificado);
        return result;
    }

}
