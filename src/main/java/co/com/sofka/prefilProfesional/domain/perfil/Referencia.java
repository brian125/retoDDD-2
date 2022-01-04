package co.com.sofka.prefilProfesional.domain.perfil;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.prefilProfesional.domain.perfil.values.Cedula;
import co.com.sofka.prefilProfesional.domain.perfil.values.NombreCompleto;
import co.com.sofka.prefilProfesional.domain.perfil.values.ReferenciaId;

public class Referencia extends Entity<ReferenciaId> {

    protected Cedula cedula;
    protected NombreCompleto nombreCompleto;

    public Referencia(ReferenciaId entityId) {
        super(entityId);
    }


}
