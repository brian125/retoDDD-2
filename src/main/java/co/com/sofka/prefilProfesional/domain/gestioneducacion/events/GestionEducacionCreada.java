package co.com.sofka.prefilProfesional.domain.gestioneducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;

public class GestionEducacionCreada extends DomainEvent {


    private HojaDeVidaId hojaDeVidaId;

    public GestionEducacionCreada(HojaDeVidaId hojaDeVidaId) {
        super("sofka.gestioneducacion.gestioneducacioncreada");
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
