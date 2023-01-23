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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Overweight that = (Overweight) o;

        if (Double.compare(that.minValue, minValue) != 0) return false;
        return Double.compare(that.maxValue, maxValue) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(minValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
