package com.eldorado.sugundaSemana.domain.entities;

import com.eldorado.sugundaSemana.domain.entities.classificadorImc.WeightClassifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("imc-data")
public class ImcData {
    @Id
    @Field("_id")
    private UUID id;
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
