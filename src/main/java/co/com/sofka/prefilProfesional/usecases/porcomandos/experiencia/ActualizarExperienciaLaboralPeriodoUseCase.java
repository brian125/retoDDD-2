package co.com.sofka.prefilProfesional.usecases.porcomandos.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.prefilProfesional.domain.experiencia.Experiencia;
import co.com.sofka.prefilProfesional.domain.experiencia.commands.ActualizarExperienciaLaboralPeriodo;


public class ActualizarExperienciaLaboralPeriodoUseCase extends UseCase<RequestCommand<ActualizarExperienciaLaboralPeriodo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarExperienciaLaboralPeriodo> requestCommand) {

        var command = requestCommand.getCommand();

        Experiencia experiencia;

        experiencia = Experiencia.from(
                command.getExperienciaId(),
                retrieveEvents()
        );

        experiencia.actualizarExperienciaLaboralPeriodo(
                command.getExperienciaLaboralId(),
                command.getPeriodo()
        );

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }

}