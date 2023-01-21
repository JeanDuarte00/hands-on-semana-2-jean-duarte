package com.eldorado.sugundaSemana.domain.entities.classificadorImc.impl;

import com.eldorado.sugundaSemana.domain.entities.ImcData;
import com.eldorado.sugundaSemana.domain.entities.classificadorImc.WeightClassifier;
import org.springframework.stereotype.Component;

@Component("noClassification")
public class NoClassification extends WeightClassifier {
    @Override
    public boolean isOnRange(ImcData data) {
        return false;
    }
}
