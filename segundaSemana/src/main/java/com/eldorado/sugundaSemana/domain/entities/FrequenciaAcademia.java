package com.eldorado.sugundaSemana.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FrequenciaAcademia {
    int quantidadeMaximaFrequencia;
    int quantidadeDiasFrequentado;

    public boolean podeEntrarNaAcademia(){
        return getQuantidadeDiasRestante() > 0;
    }

    public int getQuantidadeDiasRestante(){
        return this.quantidadeMaximaFrequencia - this.quantidadeDiasFrequentado;
    }

    public void aumentarDiaFrequentado(){
        if(podeEntrarNaAcademia())
            this.quantidadeDiasFrequentado = this.quantidadeDiasFrequentado + 1;
    }
}
