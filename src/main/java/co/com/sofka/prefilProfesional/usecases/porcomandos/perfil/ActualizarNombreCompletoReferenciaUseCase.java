package co.com.sofka.prefilProfesional.usecases.porcomandos.perfil;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.perfil.Perfil;
import co.com.sofka.prefilProfesional.domain.perfil.commands.ActualizarNombreCompletoReferencia;
import co.com.sofka.prefilProfesional.domain.perfil.values.*;

public class ActualizarNombreCompletoReferenciaUseCase extends UseCase<RequestCommand<ActualizarNombreCompletoReferencia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCompletoReferencia> requestCommand) {

        var command = requestCommand.getCommand();

        Perfil perfil;

        perfil = new Perfil(
                new PerfilId(),
                new HojaDeVidaId("cvxxx"),
                new InformacionContacto("0000000001"),
                new FotoPerfil("https://miruta.com")
        );

        perfil.agregarNuevaReferencia(
                new Cedula("1234567899"),
                new InformacionContacto("0000000002"),
                new NombreCompleto("Juan Londoño")
        );

        perfil.actualizarNombreCompletoReferencia(
                command.getReferenciaId(),
                command.getNombreCompleto()
        );

        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }

}
