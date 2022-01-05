package co.com.sofka.prefilProfesional.usecases.porcomandos.perfil;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.perfil.commands.ActualizarNombreCompletoReferencia;
import co.com.sofka.prefilProfesional.domain.perfil.events.NombreCompletoReferenciaActualizado;
import co.com.sofka.prefilProfesional.domain.perfil.events.NuevaReferenciaAgregada;
import co.com.sofka.prefilProfesional.domain.perfil.events.PerfilCreado;
import co.com.sofka.prefilProfesional.domain.perfil.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarNombreCompletoReferenciaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarNombreCompletoReferenciaUseCaseTest() {
        //Arrange
        PerfilId perfilId = PerfilId.of("1");
        ReferenciaId referenciaId = ReferenciaId.of("xxxx");

        var command = new ActualizarNombreCompletoReferencia(perfilId, referenciaId, new NombreCompleto("Juan David Restrepo"));
        var useCase = new ActualizarNombreCompletoReferenciaUseCase();

        //Act
        when(repository.getEventsBy(perfilId.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(perfilId.toString())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Assert
        var event = (NombreCompletoReferenciaActualizado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.getReferenciaId().value());
        Assertions.assertEquals("Juan David Restrepo", event.getNombreCompleto().value());
    }

    private List<DomainEvent> eventList(){
        return List.of(new PerfilCreado(
                new HojaDeVidaId("cvxxx"),
                new InformacionContacto("3012254789"),
                new FotoPerfil("https://miruta.com")
                ),
                new NuevaReferenciaAgregada(ReferenciaId.of("xxxx"),
                        new Cedula("1152700580"),
                        new InformacionContacto("3117878607"),
                        new NombreCompleto("Juan Restrepo")
                ));
    }

}