package com.eldorado.sugundaSemana.usecase;

import com.eldorado.sugundaSemana.domain.entities.ImcData;
import com.eldorado.sugundaSemana.domain.entities.classificadorImc.IWeightClassifier;
import com.eldorado.sugundaSemana.domain.entities.classificadorImc.WeightClassifier;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ClassifierUseCase {

    @Qualifier("underweight")
    IWeightClassifier underweight;

    @Qualifier("normal")
    IWeightClassifier normal;

    @Qualifier("overweight")
    IWeightClassifier overweight;

    @Qualifier("obese")
    IWeightClassifier obese;

    @Qualifier("noClassification")
    IWeightClassifier noClassification;

    public ImcData classify(ImcData data){

        data.setDataAfericao(LocalDate.now());
        data.setClassificacao((WeightClassifier)getiWeightClassifier(data));

        return data;
    }

    private IWeightClassifier getiWeightClassifier(ImcData data) {
        if(underweight.isOnRange(data))
            return underweight;

        if(normal.isOnRange(data))
            return normal;

        if(overweight.isOnRange(data))
            return overweight;

        if(obese.isOnRange(data))
            return obese;

        return noClassification;
    }

}
