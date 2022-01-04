package co.com.sofka.prefilProfesional.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.generics.NombreCompleto;
import co.com.sofka.prefilProfesional.domain.perfil.values.ReferenciaId;

public class NombreCompletoReferenciaActualizado extends DomainEvent {

    private final ReferenciaId referenciaId;
    private final NombreCompleto nombreCompleto;

    public NombreCompletoReferenciaActualizado(ReferenciaId referenciaId, NombreCompleto nombreCompleto) {
        super("sofka.perfil.nombrecompletoreferenciaactualizado");
        this.referenciaId = referenciaId;
        this.nombreCompleto = nombreCompleto;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
