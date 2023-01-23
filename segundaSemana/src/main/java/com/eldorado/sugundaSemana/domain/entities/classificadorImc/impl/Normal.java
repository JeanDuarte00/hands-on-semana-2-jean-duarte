package com.eldorado.sugundaSemana.domain.entities.classificadorImc.impl;

import com.eldorado.sugundaSemana.domain.entities.ImcData;
import com.eldorado.sugundaSemana.domain.entities.classificadorImc.WeightClassifier;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component("normal")
@Data
@NoArgsConstructor
public class Normal extends WeightClassifier {

    private double minValue = 18.5;
    private double maxValue = 25;
    @Override
    public boolean isOnRange(ImcData data) {
        return data.getImc() > minValue && data.getImc() < maxValue;
    }

}
