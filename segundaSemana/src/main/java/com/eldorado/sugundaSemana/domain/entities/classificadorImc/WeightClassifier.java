package com.eldorado.sugundaSemana.domain.entities.classificadorImc;

import lombok.Data;

@Data
public abstract class WeightClassifier implements IWeightClassifier{

    String type;

    protected WeightClassifier(){
        this.type = getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "You're on: '" + this.type + "' weight";
    }
}
