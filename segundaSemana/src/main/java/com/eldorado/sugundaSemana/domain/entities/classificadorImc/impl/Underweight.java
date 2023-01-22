package com.eldorado.sugundaSemana.domain.entities.classificadorImc.impl;

import com.eldorado.sugundaSemana.domain.entities.ImcData;
import com.eldorado.sugundaSemana.domain.entities.classificadorImc.WeightClassifier;
import org.springframework.stereotype.Component;

@Component("underweight")
public class Underweight extends WeightClassifier {

    private double maxValue = 18.5;
    @Override
    public boolean isOnRange(ImcData data) {
        return data.getImc() < maxValue;
    }
}
