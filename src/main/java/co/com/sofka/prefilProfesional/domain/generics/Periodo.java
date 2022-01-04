package co.com.sofka.prefilProfesional.domain.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Periodo implements ValueObject<String> {

    private final String value;

    public Periodo(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El periodo no puede estar vacío");
        }
        if (this.value.length() > 25) {
            throw new IllegalArgumentException("La fecha del periodo no puede contener mas de 25 caracteres");
        }
        if (!this.value.matches("[/s][-][/][0-9]*")){
            throw new IllegalArgumentException("La fecha del periodo debe serguir el siguiente formato yyyy/mm/dd - yyyy/mm/dd");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periodo periodo = (Periodo) o;
        return Objects.equals(value, periodo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}
