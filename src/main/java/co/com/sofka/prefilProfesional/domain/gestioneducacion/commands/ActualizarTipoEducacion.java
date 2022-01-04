package co.com.sofka.prefilProfesional.domain.gestioneducacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.EducacionId;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.GestionEducacionId;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.Tipo;

public class ActualizarTipoEducacion extends Command {

    private final GestionEducacionId gestionEducacionId;
    private final EducacionId educacionId;
    private final Tipo tipo;

    public ActualizarTipoEducacion(GestionEducacionId gestionEducacionId, EducacionId educacionId, Tipo tipo) {
        this.gestionEducacionId = gestionEducacionId;
        this.educacionId = educacionId;
        this.tipo = tipo;
    }

    public GestionEducacionId getGestionEducacionId() {
        return gestionEducacionId;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
