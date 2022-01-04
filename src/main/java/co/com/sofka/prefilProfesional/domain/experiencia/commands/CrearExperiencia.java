package co.com.sofka.prefilProfesional.domain.experiencia.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.prefilProfesional.domain.experiencia.ExperienciaLaboral;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaId;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;

public class CrearExperiencia extends Command {

    private final ExperienciaId experienciaId;
    private final HojaDeVidaId hojaDeVidaId;
    private final ExperienciaLaboral experienciaLaboral;

    public CrearExperiencia(ExperienciaId experienciaId, HojaDeVidaId hojaDeVidaId, ExperienciaLaboral experienciaLaboral) {
        this.experienciaId = experienciaId;
        this.hojaDeVidaId = hojaDeVidaId;
        this.experienciaLaboral = experienciaLaboral;
    }

    public ExperienciaId getIdExperiencia() {
        return experienciaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public ExperienciaLaboral getExperienciaLaboral() {
        return experienciaLaboral;
    }

}