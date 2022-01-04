package co.com.sofka.prefilProfesional.domain.gestioneducacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.GestionEducacionId;

public class CrearGestionEducacion  extends Command {

    private final GestionEducacionId gestionEducacionId;
    private final HojaDeVidaId hojaDeVidaId;

    public CrearGestionEducacion(GestionEducacionId gestionEducacionId, HojaDeVidaId hojaDeVidaId) {
        this.gestionEducacionId = gestionEducacionId;
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public GestionEducacionId getGestionEducacionId() {
        return gestionEducacionId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
