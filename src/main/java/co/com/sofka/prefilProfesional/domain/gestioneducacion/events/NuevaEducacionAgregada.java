package co.com.sofka.prefilProfesional.domain.gestioneducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.EducacionId;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.Estudio;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.TarjetaProfesional;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.Tipo;

public class NuevaEducacionAgregada extends DomainEvent {

    private EducacionId id;
    private TarjetaProfesional tarjetaProfesional;
    private Tipo tipo;
    private Estudio estudio;
    private Institucion institucion;
    private Periodo periodo;

    public NuevaEducacionAgregada(EducacionId id, TarjetaProfesional tarjetaProfesional, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super("sofka.gestioneducacion.educacionagregada");
        this.id = id;
        this.tarjetaProfesional = tarjetaProfesional;
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public EducacionId getId() {
        return id;
    }

    public TarjetaProfesional getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
