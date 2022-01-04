package co.com.sofka.prefilProfesional.domain.experiencia;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.experiencia.events.ExperienciaCreada;
import co.com.sofka.prefilProfesional.domain.experiencia.events.NuevaExperienciaLaboralAgregada;
import co.com.sofka.prefilProfesional.domain.experiencia.events.PeriodoExperinciaLaboralActualizado;
import co.com.sofka.prefilProfesional.domain.experiencia.values.*;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;

import java.util.List;
import java.util.Objects;

public class Experiencia extends AggregateEvent<ExperienciaId> {

    protected ExperienciaLaboral experienciaLaboral;
    protected HojaDeVidaId hojaDeVidaId;

    public Experiencia(ExperienciaId entityId, HojaDeVidaId hojaDeVidaId) {
        super(entityId);
        this.hojaDeVidaId = Objects.requireNonNull(hojaDeVidaId);
        appendChange(new ExperienciaCreada(hojaDeVidaId)).apply();
    }

    public Experiencia(ExperienciaId experienciaId) {
        super(experienciaId);
        subscribe(new ExperienciaChange(this));
    }

    public static Experiencia from(ExperienciaId entityId, List<DomainEvent> events){
        var experiencia = new Experiencia(entityId);
        events.forEach(experiencia::applyEvent);
        return experiencia;
    }

    public void agregarExperienciaLaboral(Institucion institucion, Periodo periodo, ConocimientosAdquiridos conocimientosAdquiridos) {
        var id = new ExperienciaLaboralId();
        Objects.requireNonNull(id);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        Objects.requireNonNull(conocimientosAdquiridos);
        appendChange(new NuevaExperienciaLaboralAgregada(id, institucion, periodo, conocimientosAdquiridos)).apply();
    }

    public void actualizarExperienciaLaboralPeriodo(ExperienciaLaboralId experienciaLaboralId, Periodo periodo){
        Objects.requireNonNull(experienciaLaboralId);
        Objects.requireNonNull(periodo);
        appendChange(new PeriodoExperinciaLaboralActualizado(experienciaLaboralId, periodo)).apply();
    }

    public ExperienciaLaboral experienciaLaboral() {
        return experienciaLaboral;
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }
}
