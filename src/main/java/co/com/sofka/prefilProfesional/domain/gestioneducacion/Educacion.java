package co.com.sofka.prefilProfesional.domain.gestioneducacion;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.EducacionId;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.Estudio;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.TarjetaProfesional;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.Tipo;

import java.util.Objects;

public class Educacion extends Entity<EducacionId> {

    protected TarjetaProfesional tarjetaProfesional;
    protected Tipo tipo;
    protected Estudio estudio;
    protected Institucion institucion;
    protected Periodo periodo;

    public Educacion(EducacionId entityId, TarjetaProfesional tarjetaProfesional, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super(entityId);
        this.tarjetaProfesional = tarjetaProfesional;
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public void actualizarTipo(Tipo tipo){
        Objects.requireNonNull(tipo);
        this.tipo = tipo;
    }

    public TarjetaProfesional tarjetaProfesional() {
        return tarjetaProfesional;
    }

    public Tipo tipo() {
        return tipo;
    }

    public Estudio estudio() {
        return estudio;
    }

    public Institucion institucion() {
        return institucion;
    }

    public Periodo periodo() {
        return periodo;
    }
}
