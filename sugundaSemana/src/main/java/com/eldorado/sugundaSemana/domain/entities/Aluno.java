package com.eldorado.sugundaSemana.domain.entities;

import com.eldorado.sugundaSemana.domain.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

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
