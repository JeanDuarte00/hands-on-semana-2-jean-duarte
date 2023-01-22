package com.eldorado.sugundaSemana.service;

import com.eldorado.sugundaSemana.domain.entities.Aluno;
import com.eldorado.sugundaSemana.infrastructure.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
@AllArgsConstructor
public class AlunoService {
  
    @Autowired
    AlunoRepository repository;

    public Aluno save (Aluno data){
        data.setId(UUID.randomUUID());
        var result =  this.repository.insert(data);
        return result;
    }

    public List<Aluno> getAll(){
        return this.repository.findAll();
    }

    public Optional<Aluno> getById(UUID id){
        return this.repository.findById(id);
    }

    public void delete(UUID id){
        this.repository.deleteById(id);
    }

    public Aluno update(Aluno data){
        return this.repository.save(data);
    }
}
