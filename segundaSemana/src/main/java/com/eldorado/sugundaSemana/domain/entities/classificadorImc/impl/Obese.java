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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Obese obese = (Obese) o;

        return Double.compare(obese.minValue, minValue) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(minValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
