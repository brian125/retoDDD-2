package co.com.sofka.prefilProfesional.usecases.porcomandos.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.prefilProfesional.domain.experiencia.Experiencia;
import co.com.sofka.prefilProfesional.domain.experiencia.commands.ActualizarExperienciaLaboralPeriodo;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaId;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;

import java.util.HashSet;
import java.util.Set;

public class ActualizarExperienciaLaboralPeriodoUseCase extends UseCase<RequestCommand<ActualizarExperienciaLaboralPeriodo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarExperienciaLaboralPeriodo> requestCommand) {

        var command = requestCommand.getCommand();

        Experiencia experiencia;

        experiencia = new Experiencia(
                new ExperienciaId(),
                new HojaDeVidaId("cvxxx")
        );

        experiencia.agregarExperienciaLaboral(
                new Institucion("Play the Kids"),
                new Periodo("2021/01/01 - 2021/12/31"),
                new ConocimientosAdquiridos("Asesor ventas")
        );

        experiencia.actualizarExperienciaLaboralPeriodo(
                command.getExperienciaLaboralId(),
                command.getPeriodo()
        );

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }

}
