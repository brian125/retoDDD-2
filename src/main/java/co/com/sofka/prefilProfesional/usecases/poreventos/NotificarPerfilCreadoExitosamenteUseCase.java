package co.com.sofka.prefilProfesional.usecases.poreventos;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.prefilProfesional.domain.perfil.events.PerfilCreado;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;
import co.com.sofka.prefilProfesional.usecases.services.EnviarNotificacionService;

import java.util.List;

public class NotificarPerfilCreadoExitosamenteUseCase extends UseCase<TriggeredEvent<PerfilCreado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<PerfilCreado> triggeredEvent) {

        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarNotificacionService.class).orElseThrow();

        Boolean esValido = service.enviarPerfil(
                "soporte@sofkaperfil.com",
                "Perfil creado exitosamente",
                PerfilId.of(event.aggregateRootId())
        );

        if (!esValido) {
            throw new BusinessException(event.aggregateRootId(), "No es posible notificar la creación del perfil profesional");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }

}
