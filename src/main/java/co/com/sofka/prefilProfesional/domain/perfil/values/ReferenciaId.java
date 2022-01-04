package co.com.sofka.prefilProfesional.domain.perfil.values;

import co.com.sofka.domain.generic.Identity;

public class ReferenciaId extends Identity {

    public ReferenciaId(String referenciaId) {
        super(referenciaId);
    }

    public ReferenciaId() {
    }

    public static ReferenciaId of(String id){
        return new ReferenciaId(id);
    }

}