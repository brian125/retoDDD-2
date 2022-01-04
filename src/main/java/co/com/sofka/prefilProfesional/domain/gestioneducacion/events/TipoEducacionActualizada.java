package co.com.sofka.prefilProfesional.domain.gestioneducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.EducacionId;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.Tipo;

public class TipoEducacionActualizada extends DomainEvent {
    private final EducacionId educacionId;
    private final Tipo tipo;

    public TipoEducacionActualizada(EducacionId educacionId, Tipo tipo) {
        super("sofka.gestioneducacion.tipoeducacionactualizada");
        this.educacionId = educacionId;
        this.tipo = tipo;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
