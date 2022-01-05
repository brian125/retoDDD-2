package co.com.sofka.prefilProfesional.usecases.porcomandos.gestioneducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.GestionEducacion;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.commands.CrearGestionEducacion;

public class CrearGestionEducacionUseCase extends UseCase<RequestCommand<CrearGestionEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearGestionEducacion> requestCommand) {
        var command = requestCommand.getCommand();

        GestionEducacion gestionEducacion;

        gestionEducacion = new GestionEducacion(
                command.getGestionEducacionId(),
                command.getHojaDeVidaId()
        );

        emit().onResponse(new ResponseEvents(gestionEducacion.getUncommittedChanges()));

    }

}
