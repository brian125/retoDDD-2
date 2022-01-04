package co.com.sofka.prefilProfesional.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.perfil.values.Cedula;
import co.com.sofka.prefilProfesional.domain.perfil.values.NombreCompleto;
import co.com.sofka.prefilProfesional.domain.perfil.values.InformacionContacto;
import co.com.sofka.prefilProfesional.domain.perfil.values.ReferenciaId;

public class NuevaReferenciaAgregada extends DomainEvent {

    private final ReferenciaId referenciaId;
    private final Cedula cedula;
    private final InformacionContacto informacionContacto;
    private final NombreCompleto nombreCompleto;

    public NuevaReferenciaAgregada(ReferenciaId referenciaId, Cedula cedula, InformacionContacto informacionContacto, NombreCompleto nombreCompleto) {
        super("sofka.perfil.nuevareferenciaagregada");
        this.referenciaId = referenciaId;
        this.cedula = cedula;
        this.informacionContacto = informacionContacto;
        this.nombreCompleto = nombreCompleto;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
