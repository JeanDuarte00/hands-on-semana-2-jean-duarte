package com.eldorado.sugundaSemana.domain.enums;

public enum Genero {
    MASCULINO('M'),
    FEMININO('F');

    private final char value;

    Genero(char genero) {
        this.value = genero;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
