package co.com.sofka.prefilProfesional.domain.experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaLaboralId;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;

public class PeriodoExperinciaLaboralActualizado extends DomainEvent {
    private ExperienciaLaboralId experienciaLaboralId;
    private Periodo periodo;

    public PeriodoExperinciaLaboralActualizado(ExperienciaLaboralId experienciaLaboralId, Periodo periodo) {
        super("Periodo experiencia laboral actualizado");
        this.experienciaLaboralId = experienciaLaboralId;
        this.periodo = periodo;
    }

    public ExperienciaLaboralId getExperienciaLaboralId() {
        return experienciaLaboralId;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
