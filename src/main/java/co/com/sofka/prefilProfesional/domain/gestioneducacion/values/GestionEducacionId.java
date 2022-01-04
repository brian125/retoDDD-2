package co.com.sofka.prefilProfesional.domain.gestioneducacion.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;

public class GestionEducacionId extends Identity {

    public GestionEducacionId(String uuid) {
        super(uuid);
    }

    public GestionEducacionId() {
    }

    public static GestionEducacionId of(String id){
        return new GestionEducacionId(id);
    }
}
