package co.com.sofka.prefilProfesional.domain.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cedula implements ValueObject<String> {

    private final String value;

    public Cedula(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La cedula no puede estar vacía");
        }
        if(this.value.length() >= 5 && this.value.length() <= 15){
            throw new IllegalArgumentException("La cedula no puede tener menos de 5 y mas de 15 caracteres");
        }
        if (!this.value.matches("[0-9]*")){
            throw new IllegalArgumentException("El teléfono sólo puede incluir números");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cedula cedula = (Cedula) o;
        return Objects.equals(value, cedula.value);
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