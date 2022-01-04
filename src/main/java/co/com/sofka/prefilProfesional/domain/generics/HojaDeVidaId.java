package co.com.sofka.prefilProfesional.domain.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HojaDeVidaId implements ValueObject<String> {

    private final String value;

    public HojaDeVidaId(String value) {
        this.value = Objects.requireNonNull(value, "El id de la hoja de vida no puede ir vacio");
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El id de la hoja de vida no puede estar en blanco");
        }
    }



    @Override
    public String value() {
        return value;
    }
}
