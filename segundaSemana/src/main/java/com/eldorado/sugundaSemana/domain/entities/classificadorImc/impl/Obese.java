package com.eldorado.sugundaSemana.domain.entities.classificadorImc.impl;

import com.eldorado.sugundaSemana.domain.entities.ImcData;
import com.eldorado.sugundaSemana.domain.entities.classificadorImc.WeightClassifier;
import org.springframework.stereotype.Component;

@Component("obese")
public class Obese extends WeightClassifier {

    private double minValue = 30;
    @Override
    public boolean isOnRange(ImcData data) {
        return data.getImc() > minValue;
    }

}
