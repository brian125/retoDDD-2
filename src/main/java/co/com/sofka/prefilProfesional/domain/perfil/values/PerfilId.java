package co.com.sofka.prefilProfesional.domain.perfil.values;

import co.com.sofka.domain.generic.Identity;

public class PerfilId extends Identity {

    public PerfilId(String id) {
        super(id);
    }

    public PerfilId() {
    }

    public static PerfilId of(String id){
        return new PerfilId(id);
    }

}