package co.com.sofka.prefilProfesional.usecases.poreventos;


import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.prefilProfesional.domain.experiencia.events.ExperienciaCreada;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaId;
import co.com.sofka.prefilProfesional.usecases.services.EnviarNotificacionService;

import java.util.List;

public class NotificarExperienciaCreadaExitosamenteUseCase extends UseCase<TriggeredEvent<ExperienciaCreada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ExperienciaCreada> triggeredEvent) {

        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarNotificacionService.class).orElseThrow();

        Boolean esValido = service.enviarExperiencia(
                "soporte@sofkaexperiencia.com",
                "Experiencia creada exitosamente",
                ExperienciaId.of(event.aggregateRootId())
        );

        if (!esValido) {
            throw new BusinessException(event.aggregateRootId(), "No es posible notificar la creación de la experiencia profesional");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
