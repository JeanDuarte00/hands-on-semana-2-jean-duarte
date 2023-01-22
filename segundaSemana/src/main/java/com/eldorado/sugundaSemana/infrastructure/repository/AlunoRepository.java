package com.eldorado.sugundaSemana.infrastructure.repository;

import com.eldorado.sugundaSemana.domain.entities.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AlunoRepository  extends MongoRepository<Aluno, UUID> {

}