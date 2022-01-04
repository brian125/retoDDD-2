package co.com.sofka.prefilProfesional.usecases.porcomandos.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.prefilProfesional.domain.experiencia.Experiencia;
import co.com.sofka.prefilProfesional.domain.experiencia.commands.CrearExperiencia;

public class CrearExperienciaUseCase extends UseCase<RequestCommand<CrearExperiencia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearExperiencia> requestCommand) {
        var command = requestCommand.getCommand();

        Experiencia experiencia;

        experiencia = new Experiencia(
                command.getIdExperiencia(),
                command.getHojaDeVidaId()
        );

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));

    }

}
