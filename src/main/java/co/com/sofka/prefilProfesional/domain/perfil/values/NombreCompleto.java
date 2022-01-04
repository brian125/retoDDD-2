package co.com.sofka.prefilProfesional.domain.perfil.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCompleto implements ValueObject<String> {

    private final String value;

    public NombreCompleto(String value) {
        this.value = Objects.requireNonNull(value, "El nombre de la referencia no puede ir vacio");
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre competo no puede ir en blanco");
        }
        if(this.value.length() < 5){
            throw new IllegalArgumentException("El nombre no puede tener menos de 5 letras");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreCompleto nombreCompleto = (NombreCompleto) o;
        return Objects.equals(value, nombreCompleto.value);
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
