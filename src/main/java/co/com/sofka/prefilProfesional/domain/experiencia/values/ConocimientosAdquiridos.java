package co.com.sofka.prefilProfesional.domain.experiencia.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.Set;

public class ConocimientosAdquiridos implements ValueObject<Set<String>> {

    private final Set<String> value;

    public ConocimientosAdquiridos(Set<String> value) {
        this.value = Objects.requireNonNull(value);
        if(value.isEmpty()) {
            throw new IllegalArgumentException("Los conococimientos adquiridos no pueden ir vacios");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConocimientosAdquiridos that = (ConocimientosAdquiridos) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Set<String> value() {
        return value;
    }
}
