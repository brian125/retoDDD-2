package co.com.sofka.prefilProfesional.domain.perfil;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.prefilProfesional.domain.perfil.values.Cedula;
import co.com.sofka.prefilProfesional.domain.perfil.values.NombreCompleto;
import co.com.sofka.prefilProfesional.domain.perfil.values.InformacionContacto;
import co.com.sofka.prefilProfesional.domain.perfil.values.ReferenciaId;

import java.util.Objects;

public class Referencia extends Entity<ReferenciaId> {

    protected Cedula cedula;
    protected InformacionContacto informacionContacto;
    protected NombreCompleto nombreCompleto;

    public Referencia(ReferenciaId entityId, Cedula cedula, InformacionContacto informacionContacto, NombreCompleto nombreCompleto) {
        super(entityId);
        this.cedula = Objects.requireNonNull(cedula);
        this.informacionContacto = Objects.requireNonNull(informacionContacto);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public void actualizarNombreCompleto(NombreCompleto nombreCompleto){
        Objects.requireNonNull(nombreCompleto);
        this.nombreCompleto = nombreCompleto;
    }

    public Cedula cedula() {
        return cedula;
    }

    public InformacionContacto informacionContacto() {
        return informacionContacto;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }
}
