package com.eldorado.sugundaSemana.domain.entities.classificadorImc.impl;

import com.eldorado.sugundaSemana.domain.entities.ImcData;
import com.eldorado.sugundaSemana.domain.entities.classificadorImc.WeightClassifier;
import org.springframework.stereotype.Component;

@Component("overweight")
public class Overweight extends WeightClassifier {

    private double minValue = 25;
    private double maxValue = 30;
    @Override
    public boolean isOnRange(ImcData data) {
        return data.getImc() > minValue && data.getImc() < maxValue;
    }

}
