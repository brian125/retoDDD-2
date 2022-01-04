package co.com.sofka.prefilProfesional.domain.experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;

public class ExperienciaCreada extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;

    public ExperienciaCreada(HojaDeVidaId hojaDeVidaId) {
        super("sofka.experiencia.experienciacreada");
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
