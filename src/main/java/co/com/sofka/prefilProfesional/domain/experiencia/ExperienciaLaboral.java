package co.com.sofka.prefilProfesional.domain.experiencia;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaLaboralId;
import co.com.sofka.prefilProfesional.domain.experiencia.values.Institucion;
import co.com.sofka.prefilProfesional.domain.experiencia.values.Periodo;

import java.util.Objects;
import java.util.Set;

public class ExperienciaLaboral extends Entity<ExperienciaLaboralId> {

    protected Institucion institucion;
    protected Periodo periodo;
    protected Set<ConocimientosAdquiridos> conocimientosAdquiridos;

    public ExperienciaLaboral(ExperienciaLaboralId entityId, Institucion institucion, Periodo periodo, Set<ConocimientosAdquiridos> conocimientosAdquiridos) {
        super(entityId);
        this.institucion = institucion;
        this.periodo = periodo;
        this.conocimientosAdquiridos = conocimientosAdquiridos;
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

    public Set<ConocimientosAdquiridos> conocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
