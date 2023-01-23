package com.eldorado.sugundaSemana.domain.entities;

import com.eldorado.sugundaSemana.domain.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("aluno")
public class Aluno {

    @Id
    @Field("_id")
    private UUID id;
    String nome;
    Identificacao identificacao;
    Genero genero;
    LocalDate dataNascimento;
    Endereco endereco;
    Contato contato;
    FrequenciaAcademia frequenciaAcademia;

    public int getIdade() {

        int age = LocalDate.now().compareTo(this.dataNascimento); // return comparation of years
        if (LocalDate.now().getMonthValue() < this.dataNascimento.getMonthValue())
            age--;
        if (this.dataNascimento.getMonthValue() == LocalDate.now().getMonthValue() && LocalDate.now().getDayOfMonth() < this.dataNascimento.getDayOfMonth() )
            age--;
        return age;
    }
}
