package co.com.sofka.prefilProfesional.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.perfil.values.FotoPerfil;
import co.com.sofka.prefilProfesional.domain.perfil.values.InformacionContacto;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;

public class CrearPerfil extends Command {

    private final PerfilId perfilId;
    private final HojaDeVidaId hojaDeVidaId;
    private final InformacionContacto informacionContacto;
    private final FotoPerfil fotoPerfil;

    public CrearPerfil(PerfilId perfilId, HojaDeVidaId hojaDeVidaId, InformacionContacto informacionContacto, FotoPerfil fotoPerfil) {
        this.perfilId = perfilId;
        this.hojaDeVidaId = hojaDeVidaId;
        this.informacionContacto = informacionContacto;
        this.fotoPerfil = fotoPerfil;
    }

    public PerfilId getPerfilId() {
        return perfilId;
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
