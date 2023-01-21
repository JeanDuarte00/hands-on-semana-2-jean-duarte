package com.eldorado.sugundaSemana.domain.entities.classificadorImc;

import com.eldorado.sugundaSemana.domain.entities.ImcData;
import lombok.Data;

@Data
public abstract class WeightClassifier implements IWeightClassifier{

    String type;

    public WeightClassifier(){
        this.type = getClass().getSimpleName();
    }
    @Override
    public abstract boolean isOnRange(ImcData data);

    @Override
    public String toString() {
        return "You're on: '" + this.type + "' weight";
    }
}
