package co.com.sofka.prefilProfesional.usecases.porcomandos.perfil;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.prefilProfesional.domain.perfil.Perfil;
import co.com.sofka.prefilProfesional.domain.perfil.commands.CrearPerfil;

public class CrearPerfilUseCase extends UseCase<RequestCommand<CrearPerfil>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPerfil> requestCommand) {
        var command = requestCommand.getCommand();

        Perfil perfil;

        perfil = new Perfil(
                command.getPerfilId(),
                command.getHojaDeVidaId(),
                command.getInformacionContacto(),
                command.getFotoPerfil()
        );

        if (!perfil.fotoPerfil().value().contains("https://")){
            throw new BusinessException(command.getPerfilId().value(), "La ruta de la foto debe estar en la nube e iniciar con https://");
        }

        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));

    }
}