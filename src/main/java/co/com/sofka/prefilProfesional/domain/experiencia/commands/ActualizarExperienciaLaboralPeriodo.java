package co.com.sofka.prefilProfesional.domain.experiencia.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaId;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaLaboralId;
import co.com.sofka.prefilProfesional.domain.experiencia.values.Periodo;

public class ActualizarExperienciaLaboralPeriodo extends Command {

    private final ExperienciaId experienciaId;
    private final ExperienciaLaboralId experienciaLaboralId;
    private final Periodo periodo;

    public ActualizarExperienciaLaboralPeriodo(ExperienciaId experienciaId, ExperienciaLaboralId experienciaLaboralId, Periodo periodo) {
        this.experienciaId = experienciaId;
        this.experienciaLaboralId = experienciaLaboralId;
        this.periodo = periodo;
    }

    public ExperienciaId getExperienciaId() {
        return experienciaId;
    }

    public ExperienciaLaboralId getExperienciaLaboralId() {
        return experienciaLaboralId;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

}