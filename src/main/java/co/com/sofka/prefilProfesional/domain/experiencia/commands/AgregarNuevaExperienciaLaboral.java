package co.com.sofka.prefilProfesional.domain.experiencia.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaId;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaLaboralId;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;

public class AgregarNuevaExperienciaLaboral extends Command {

    private final ExperienciaId experienciaId;
    private final ExperienciaLaboralId experienciaLaboralId;
    private final Periodo periodo;
    private final Institucion institucion;

    public AgregarNuevaExperienciaLaboral(ExperienciaId experienciaId, ExperienciaLaboralId experienciaLaboralId, Periodo periodo, Institucion institucion) {
        this.experienciaId = experienciaId;
        this.experienciaLaboralId = experienciaLaboralId;
        this.periodo = periodo;
        this.institucion = institucion;
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

    public Institucion getInstitucion() {
        return institucion;
    }

}