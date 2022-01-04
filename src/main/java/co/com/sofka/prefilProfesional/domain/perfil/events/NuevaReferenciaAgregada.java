package co.com.sofka.prefilProfesional.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.generics.Cedula;
import co.com.sofka.prefilProfesional.domain.generics.NombreCompleto;
import co.com.sofka.prefilProfesional.domain.perfil.values.InformacionContacto;

public class NuevaReferenciaAgregada extends DomainEvent {

    private final Cedula cedula;
    private final InformacionContacto informacionContacto;
    private final NombreCompleto nombreCompleto;

    public NuevaReferenciaAgregada(Cedula cedula, InformacionContacto informacionContacto, NombreCompleto nombreCompleto) {
        super("sofka.perfil.nuevareferenciaagregada");
        this.cedula = cedula;
        this.informacionContacto = informacionContacto;
        this.nombreCompleto = nombreCompleto;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
