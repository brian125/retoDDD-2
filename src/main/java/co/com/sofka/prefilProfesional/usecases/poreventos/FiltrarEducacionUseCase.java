package co.com.sofka.prefilProfesional.usecases.poreventos;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.Educacion;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.*;
import co.com.sofka.prefilProfesional.domain.perfil.events.PerfilCreado;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;
import co.com.sofka.prefilProfesional.usecases.services.EnviarNotificacionService;
import co.com.sofka.prefilProfesional.usecases.services.FiltrarService;

import java.util.List;

public class FiltrarEducacionUseCase extends UseCase<TriggeredEvent<NuevaEducacionAgregada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<NuevaEducacionAgregada> triggeredEvent) {

        var event = triggeredEvent.getDomainEvent();
        var gestionEducacionId = GestionEducacionId.of(event.aggregateRootId());
        var service = getService(FiltrarService.class).orElseThrow();

        Boolean esValido = service.filtrar(
                event.getEstudio(),
                event.getEstudio(),
                gestionEducacionId
        );

        if (!esValido) {
            throw new BusinessException(event.aggregateRootId(), "No se encontraron coincidencias");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }

}
