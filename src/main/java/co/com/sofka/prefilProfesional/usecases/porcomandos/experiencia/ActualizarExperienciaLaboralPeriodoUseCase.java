package co.com.sofka.prefilProfesional.usecases.porcomandos.experiencia;

import co.com.sofka.business.generic.BusinessException;
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

        if (experiencia.experienciaLaboral().periodo().value().length() > 3) {
            throw new BusinessException(command.getExperienciaId().value(), "El periodo de la experiencia no puede superar los 999 meses");
        }

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }

}