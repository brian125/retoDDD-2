package co.com.sofka.prefilProfesional.usecases.porcomandos.gestioneducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.GestionEducacion;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.commands.ActualizarTipoEducacion;

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
