package com.eldorado.sugundaSemana.domain.entities;

import com.eldorado.sugundaSemana.domain.entities.classificadorImc.WeightClassifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImcData {

    double altura;
    double peso;
    @Nullable
    LocalDate dataAfericao;
    @Nullable
    WeightClassifier classificacao;
    public double getImc(){
        var imc = peso / (altura * altura);
        return formatToDoubleScaled(imc, 2);
    }

    private double formatToDoubleScaled(double value, int scale){
        var decimal = BigDecimal.valueOf(value);
        decimal = decimal.setScale(scale, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }

    @Override
    public String toString() {
        return "ImcData{" +
                "altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
