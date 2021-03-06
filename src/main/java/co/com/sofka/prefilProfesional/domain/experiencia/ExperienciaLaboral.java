package co.com.sofka.prefilProfesional.domain.experiencia;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaLaboralId;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;

import java.util.Objects;

public class ExperienciaLaboral extends Entity<ExperienciaLaboralId> {

    protected Institucion institucion;
    protected Periodo periodo;
    protected ConocimientosAdquiridos conocimientosAdquiridos;

    public ExperienciaLaboral(ExperienciaLaboralId entityId, Institucion institucion, Periodo periodo, ConocimientosAdquiridos conocimientosAdquiridos) {
        super(entityId);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
        this.conocimientosAdquiridos = Objects.requireNonNull(conocimientosAdquiridos);
    }

    public void actualizarPeriodo (Periodo periodo){
        Objects.requireNonNull(periodo);
        this.periodo = periodo;
    }

    public Institucion institucion() {
        return institucion;
    }

    public Periodo periodo() {
        return periodo;
    }

    public ConocimientosAdquiridos conocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
