package co.com.sofka.prefilProfesional.domain.perfil;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.generics.Cedula;
import co.com.sofka.prefilProfesional.domain.generics.NombreCompleto;
import co.com.sofka.prefilProfesional.domain.perfil.events.NombreCompletoReferenciaActualizado;
import co.com.sofka.prefilProfesional.domain.perfil.events.NuevaReferenciaAgregada;
import co.com.sofka.prefilProfesional.domain.perfil.events.PerfilCreado;
import co.com.sofka.prefilProfesional.domain.perfil.values.FotoPerfil;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.perfil.values.InformacionContacto;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;
import co.com.sofka.prefilProfesional.domain.perfil.values.ReferenciaId;

import java.util.List;
import java.util.Objects;

public class Perfil  extends AggregateEvent<PerfilId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected InformacionContacto informacionContacto;
    protected FotoPerfil fotoPerfil;

    public Perfil(PerfilId entityId, HojaDeVidaId hojaDeVidaId, InformacionContacto informacionContacto, FotoPerfil fotoPerfil) {
        super(entityId);
        this.hojaDeVidaId = Objects.requireNonNull(hojaDeVidaId);
        this.informacionContacto = Objects.requireNonNull(informacionContacto);
        this.fotoPerfil = Objects.requireNonNull(fotoPerfil);
        appendChange(new PerfilCreado(hojaDeVidaId,informacionContacto,fotoPerfil)).apply();
    }

    public Perfil(PerfilId perfilId) {
        super(perfilId);
        subscribe(new PerfilChange(this));
    }

    public static Perfil from(PerfilId entityId, List<DomainEvent> events){
        var perfil = new Perfil(entityId);
        events.forEach(perfil::applyEvent);
        return perfil;
    }

    public void agregarNuevaReferencia(Cedula cedula, InformacionContacto informacionContacto, NombreCompleto nombreCompleto) {
        var id = new ReferenciaId();
        Objects.requireNonNull(cedula);
        Objects.requireNonNull(informacionContacto);
        Objects.requireNonNull(nombreCompleto);
        appendChange(new NuevaReferenciaAgregada(id, cedula, informacionContacto, nombreCompleto)).apply();
    }

    public void actualizarNombreCompletoReferencia(ReferenciaId referenciaId, NombreCompleto nombreCompleto){
        Objects.requireNonNull(referenciaId);
        Objects.requireNonNull(nombreCompleto);
        appendChange(new NombreCompletoReferenciaActualizado(referenciaId, nombreCompleto)).apply();
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

    public InformacionContacto informacionContacto() {
        return informacionContacto;
    }

    public FotoPerfil fotoPerfil() {
        return fotoPerfil;
    }
}
