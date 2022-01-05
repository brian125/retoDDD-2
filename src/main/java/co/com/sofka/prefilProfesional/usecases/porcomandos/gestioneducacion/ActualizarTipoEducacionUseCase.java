package co.com.sofka.prefilProfesional.usecases.porcomandos.gestioneducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.prefilProfesional.domain.experiencia.Experiencia;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.GestionEducacion;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.commands.ActualizarTipoEducacion;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.Estudio;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.GestionEducacionId;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.TarjetaProfesional;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.Tipo;

public class ActualizarTipoEducacionUseCase extends UseCase<RequestCommand<ActualizarTipoEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarTipoEducacion> requestCommand) {

        var command = requestCommand.getCommand();

        GestionEducacion gestionEducacion;

        gestionEducacion = GestionEducacion.from(
                command.getGestionEducacionId(),
                retrieveEvents()
        );

        gestionEducacion.actualizarTipoEducacion(
                command.getEducacionId(),
                command.getTipo()
        );

        emit().onResponse(new ResponseEvents(gestionEducacion.getUncommittedChanges()));
    }
}
