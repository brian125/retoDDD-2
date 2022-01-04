package co.com.sofka.prefilProfesional.domain.perfil;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.prefilProfesional.domain.perfil.values.FotoPerfil;
import co.com.sofka.prefilProfesional.domain.perfil.values.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.perfil.values.InformacionContacto;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;

public class Perfil  extends AggregateEvent<PerfilId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected InformacionContacto informacionContacto;
    protected FotoPerfil fotoPerfil;


    public Perfil(PerfilId entityId) {
        super(entityId);
    }



}
