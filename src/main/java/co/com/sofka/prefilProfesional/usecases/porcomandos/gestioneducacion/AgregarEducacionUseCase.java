package co.com.sofka.prefilProfesional.usecases.porcomandos.gestioneducacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.GestionEducacion;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.commands.AgregarNuevaEducacion;

public class AgregarEducacionUseCase extends UseCase<RequestCommand<AgregarNuevaEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarNuevaEducacion> requestCommand) {

        var command = requestCommand.getCommand();

        GestionEducacion gestionEducacion;

        gestionEducacion = GestionEducacion.from(
                command.getGestionEducacionId(),
                retrieveEvents()
        );

        gestionEducacion.agregarNuevaEducacion(
                command.getTarjetaProfesional(),
                command.getTipo(),
                command.getEstudio(),
                command.getInstitucion(),
                command.getPeriodo()
        );

        if (!(gestionEducacion.educacion().tarjetaProfesional().value().respuesta().equalsIgnoreCase("y") || gestionEducacion.educacion().tarjetaProfesional().value().retorno())) {
            throw new BusinessException(command.getGestionEducacionId().value(), "El aspirante debe tener tarjeta profesional de su educación");
        }

        emit().onResponse(new ResponseEvents(gestionEducacion.getUncommittedChanges()));
    }

}
