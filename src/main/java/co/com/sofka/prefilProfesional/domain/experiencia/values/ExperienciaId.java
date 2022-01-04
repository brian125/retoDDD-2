package co.com.sofka.prefilProfesional.domain.experiencia.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;

public class ExperienciaId extends Identity {

    public ExperienciaId(String uuid) {
        super(uuid);
    }

    public ExperienciaId() {
    }

    public static ExperienciaId of(String id){
        return new ExperienciaId(id);
    }

}
