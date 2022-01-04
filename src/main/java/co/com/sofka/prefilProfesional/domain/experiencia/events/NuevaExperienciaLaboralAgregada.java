package co.com.sofka.prefilProfesional.domain.experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.experiencia.values.*;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;


public class NuevaExperienciaLaboralAgregada extends DomainEvent {

    private final ExperienciaLaboralId id;
    private final Institucion institucion;
    private final Periodo periodo;
    private final ConocimientosAdquiridos conocimientosAdquiridos;

    public NuevaExperienciaLaboralAgregada(ExperienciaLaboralId id, Institucion institucion, Periodo periodo, ConocimientosAdquiridos conocimientosAdquiridos) {
        super("sofka.experiencia.nuevaexperiencialaboralagregada");
        this.id = id;
        this.institucion = institucion;
        this.periodo = periodo;
        this.conocimientosAdquiridos = conocimientosAdquiridos;
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

    public ConocimientosAdquiridos getConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
