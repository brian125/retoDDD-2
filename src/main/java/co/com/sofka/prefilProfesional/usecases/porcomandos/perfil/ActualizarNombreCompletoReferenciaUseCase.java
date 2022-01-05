package co.com.sofka.prefilProfesional.usecases.porcomandos.perfil;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.prefilProfesional.domain.perfil.Perfil;
import co.com.sofka.prefilProfesional.domain.perfil.commands.ActualizarNombreCompletoReferencia;

public class ActualizarNombreCompletoReferenciaUseCase extends UseCase<RequestCommand<ActualizarNombreCompletoReferencia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCompletoReferencia> requestCommand) {

        var command = requestCommand.getCommand();

        Perfil perfil;

        perfil = Perfil.from(
                command.getPerfilId(),
                retrieveEvents()
        );

        perfil.actualizarNombreCompletoReferencia(
                command.getReferenciaId(),
                command.getNombreCompleto()
        );

        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }

}