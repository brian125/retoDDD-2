package co.com.sofka.prefilProfesional.domain.experiencia.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;

public class ExperienciaLaboralId extends Identity {

    public ExperienciaLaboralId(String uuid) {
        super(uuid);
    }

    public ExperienciaLaboralId() {
    }

    public static ExperienciaLaboralId of(String id){
        return new ExperienciaLaboralId(id);
    }
}
