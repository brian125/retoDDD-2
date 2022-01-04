package co.com.sofka.prefilProfesional.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.perfil.values.FotoPerfil;
import co.com.sofka.prefilProfesional.domain.perfil.values.InformacionContacto;

public class PerfilCreado extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;
    private final InformacionContacto informacionContacto;
    private final FotoPerfil fotoPerfil;

    public PerfilCreado(HojaDeVidaId hojaDeVidaId, InformacionContacto informacionContacto, FotoPerfil fotoPerfil) {
        super("sofka.perfil.perfilcreado");
        this.hojaDeVidaId = hojaDeVidaId;
        this.informacionContacto = informacionContacto;
        this.fotoPerfil = fotoPerfil;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public FotoPerfil getFotoPerfil() {
        return fotoPerfil;
    }
}
