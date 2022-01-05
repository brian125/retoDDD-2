package co.com.sofka.prefilProfesional.usecases.poreventos;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.perfil.events.PerfilCreado;
import co.com.sofka.prefilProfesional.domain.perfil.values.FotoPerfil;
import co.com.sofka.prefilProfesional.domain.perfil.values.InformacionContacto;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;
import co.com.sofka.prefilProfesional.usecases.services.EnviarNotificacionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificarPerfilCreadoExitosamenteUseCaseTest {

    @Mock
    EnviarNotificacionService notificacionService;

    @Test
    void notificarPerfilCreadoExitosamenteUseCaseTest() {

        PerfilId perfilId = PerfilId.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");
        InformacionContacto informacionContacto = new InformacionContacto("3001112233");
        FotoPerfil fotoPerfil = new FotoPerfil("https://mipath.com");

        var event = new PerfilCreado(hojaDeVidaId,informacionContacto,fotoPerfil);
        event.setAggregateRootId(perfilId.value());
        var useCase = new NotificarPerfilCreadoExitosamenteUseCase();

        when(notificacionService.enviar(
                "soporte@sofkaperfil.com",
                "Perfil creado exitosamente",
                perfilId
                )).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(notificacionService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(notificacionService).enviar(
                "soporte@sofkaperfil.com",
                "Perfil creado exitosamente",
                perfilId
        );
    }

    @Test
    void notificarPerfil_error() {

        PerfilId perfilId = PerfilId.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");
        InformacionContacto informacionContacto = new InformacionContacto("3001112233");
        FotoPerfil fotoPerfil = new FotoPerfil("https://mipath.com");

        var event = new PerfilCreado(hojaDeVidaId,informacionContacto,fotoPerfil);
        event.setAggregateRootId(perfilId.value());
        var useCase = new NotificarPerfilCreadoExitosamenteUseCase();

        when(notificacionService.enviar(
                "soporte@sofkaperfil.com",
                "Perfil creado exitosamente",
                perfilId
        )).thenReturn(false);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(notificacionService);
        useCase.addServiceBuilder(builder);

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .syncExecutor(useCase, new TriggeredEvent<>(event))
                    .orElseThrow();
        });
    }

}