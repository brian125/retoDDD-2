package co.com.sofka.prefilProfesional.domain.experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.experiencia.values.*;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;

import java.util.Set;

public class NuevaExperienciaLaboralAgregada extends DomainEvent {

    private ExperienciaLaboralId id;
    private Institucion institucion;
    private Periodo periodo;
    private Set<ConocimientosAdquiridos> conocimientosAdquiridos;

    public NuevaExperienciaLaboralAgregada(ExperienciaLaboralId id, Institucion institucion, Periodo periodo, Set<ConocimientosAdquiridos> conocimientosAdquiridos) {
        super("sofka.experiencia.nuevaexperiencialaboralagregada");
        this.id = id;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public ExperienciaLaboralId getId() {
        return id;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public Set<ConocimientosAdquiridos> getConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
