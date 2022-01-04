package co.com.sofka.prefilProfesional.domain.gestioneducacion.values;


import co.com.sofka.domain.generic.Identity;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;

public class EducacionId extends Identity {

    public EducacionId(String id) {
        super(id);
    }

    public EducacionId() {
    }

    public static EducacionId of(String id){
        return new EducacionId(id);
    }

}
