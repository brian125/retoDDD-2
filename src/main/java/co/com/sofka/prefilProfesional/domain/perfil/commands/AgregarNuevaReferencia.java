package co.com.sofka.prefilProfesional.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.prefilProfesional.domain.perfil.values.Cedula;
import co.com.sofka.prefilProfesional.domain.perfil.values.NombreCompleto;
import co.com.sofka.prefilProfesional.domain.perfil.values.InformacionContacto;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;
import co.com.sofka.prefilProfesional.domain.perfil.values.ReferenciaId;

public class AgregarNuevaReferencia extends Command {

    private final PerfilId perfilId;
    private final ReferenciaId referenciaId;
    private final Cedula cedula;
    private final InformacionContacto informacionContacto;
    private final NombreCompleto nombreCompleto;

    public AgregarNuevaReferencia(PerfilId perfilId, ReferenciaId referenciaId, Cedula cedula, InformacionContacto informacionContacto, NombreCompleto nombreCompleto) {
        this.perfilId = perfilId;
        this.referenciaId = referenciaId;
        this.cedula = cedula;
        this.informacionContacto = informacionContacto;
        this.nombreCompleto = nombreCompleto;
    }

    public PerfilId getPerfilId() {
        return perfilId;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
