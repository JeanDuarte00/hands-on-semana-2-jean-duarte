package com.eldorado.sugundaSemana.domain.entities.classificadorImc;

import com.eldorado.sugundaSemana.domain.entities.ImcData;

public interface IWeightClassifier {


    boolean isOnRange(ImcData data);
    String toString();
}
