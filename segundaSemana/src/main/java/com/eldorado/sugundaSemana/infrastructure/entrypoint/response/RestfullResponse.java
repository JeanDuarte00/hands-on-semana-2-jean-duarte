package com.eldorado.sugundaSemana.infrastructure.entrypoint.response;

import lombok.Data;
import lombok.NonNull;

@Data
public class RestfullResponse<T> {

    @NonNull
    T dataResponse;
    String buscarRecurso;
    String deletarRecurso;
    String atualizarRecurso;

    public RestfullResponse(T data){
        this.dataResponse = data;
    }

}
