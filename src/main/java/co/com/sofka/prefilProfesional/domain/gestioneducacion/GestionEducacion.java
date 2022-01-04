package co.com.sofka.prefilProfesional.domain.gestioneducacion;


import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.GestionEducacionCreada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.TipoEducacionActualizada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.*;

import java.util.List;
import java.util.Objects;

public class GestionEducacion extends AggregateEvent<GestionEducacionId> {

    protected Educacion educacion;
    protected HojaDeVidaId hojaDeVidaId;

    public GestionEducacion(GestionEducacionId entityId, HojaDeVidaId hojaDeVidaId) {
        super(entityId);
        this.hojaDeVidaId = Objects.requireNonNull(hojaDeVidaId);
        appendChange(new GestionEducacionCreada(hojaDeVidaId)).apply();
    }

    public GestionEducacion(GestionEducacionId gestionEducacionId) {
        super(gestionEducacionId);
        subscribe(new GestionEducacionChange(this));
    }

    public static GestionEducacion from(GestionEducacionId entityId, List<DomainEvent> events){
        var gestionEducacion = new GestionEducacion(entityId);
        events.forEach(gestionEducacion::applyEvent);
        return gestionEducacion;
    }

    public void agregarNuevaEducacion(TarjetaProfesional tarjetaProfesional, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        var id = new EducacionId();
        Objects.requireNonNull(tarjetaProfesional);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(estudio);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        appendChange(new NuevaEducacionAgregada(id, tarjetaProfesional, tipo, estudio, institucion, periodo)).apply();
    }

    public void actualizarTipoEducacion(EducacionId educacionId, Tipo tipo){
        Objects.requireNonNull(educacionId);
        Objects.requireNonNull(tipo);
        appendChange(new TipoEducacionActualizada(educacionId, tipo)).apply();
    }

    public Educacion educacion() {
        return educacion;
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }
}
