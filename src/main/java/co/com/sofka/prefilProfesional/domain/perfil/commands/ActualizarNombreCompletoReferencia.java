package co.com.sofka.prefilProfesional.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.prefilProfesional.domain.perfil.values.NombreCompleto;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;
import co.com.sofka.prefilProfesional.domain.perfil.values.ReferenciaId;

public class ActualizarNombreCompletoReferencia extends Command {

    private final PerfilId perfilId;
    private final ReferenciaId referenciaId;
    private final NombreCompleto nombreCompleto;

    public ActualizarNombreCompletoReferencia(PerfilId perfilId, ReferenciaId referenciaId, NombreCompleto nombreCompleto) {
        this.perfilId = perfilId;
        this.referenciaId = referenciaId;
        this.nombreCompleto = nombreCompleto;
    }

    public PerfilId getPerfilId() {
        return perfilId;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
