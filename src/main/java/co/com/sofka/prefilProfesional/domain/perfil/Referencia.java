package co.com.sofka.prefilProfesional.domain.perfil;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.prefilProfesional.domain.generics.Cedula;
import co.com.sofka.prefilProfesional.domain.generics.NombreCompleto;
import co.com.sofka.prefilProfesional.domain.perfil.values.InformacionContacto;
import co.com.sofka.prefilProfesional.domain.perfil.values.ReferenciaId;

public class Referencia extends Entity<ReferenciaId> {

    protected Cedula cedula;
    protected InformacionContacto informacionContacto;
    protected NombreCompleto nombreCompleto;

    public Referencia(ReferenciaId entityId) {
        super(entityId);
    }

}
