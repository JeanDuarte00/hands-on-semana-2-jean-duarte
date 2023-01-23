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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Underweight that = (Underweight) o;

        return Double.compare(that.maxValue, maxValue) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(maxValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
