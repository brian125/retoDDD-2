package co.com.sofka.prefilProfesional.domain.perfil.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FotoPerfil implements ValueObject<String> {

    private final String path;

    public FotoPerfil(String path) {
        this.path = Objects.requireNonNull(path, "La ruta de la foto no debe ir vacia");
        if(this.path.isBlank()){
            throw new IllegalArgumentException("La ruta no puede ir en blanco");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoPerfil that = (FotoPerfil) o;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    @Override
    public String value() {
        return path;
    }
}
