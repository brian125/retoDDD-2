package co.com.sofka.prefilProfesional.usecases.porcomandos.gestioneducacion;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.commands.ActualizarTipoEducacion;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.GestionEducacionCreada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.TipoEducacionActualizada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarTipoEducacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarTipoEducacionUseCaseTest() {
        //Arrange
        GestionEducacionId gestionEducacionId = GestionEducacionId.of("1");
        EducacionId educacionId = EducacionId.of("xxxx");

        var command = new ActualizarTipoEducacion(gestionEducacionId, educacionId, new Tipo("Profesional"));
        var useCase = new ActualizarTipoEducacionUseCase();

        //Act
        when(repository.getEventsBy(gestionEducacionId.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(gestionEducacionId.toString())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Assert
        var event = (TipoEducacionActualizada)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.getEducacionId().value());
        Assertions.assertEquals("Profesional", event.getTipo().value());
    }

    private List<DomainEvent> eventList(){
        return List.of(new GestionEducacionCreada(new HojaDeVidaId("cvxxx")),
                new NuevaEducacionAgregada(EducacionId.of("xxxx"),
                        new TarjetaProfesional("y", true),
                        new Tipo("Tecnico"),
                        new Estudio("Sistemas"),
                        new Institucion("Politecnico JIC"),
                        new Periodo("6")
                ));
    }

}