package co.com.sofka.prefilProfesional.usecases.porcomandos.gestioneducacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.commands.AgregarNuevaEducacion;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.GestionEducacionCreada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarEducacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarEducacionUseCaseTest(){
        GestionEducacionId gestionEducacionId = GestionEducacionId.of("xxxx");
        EducacionId educacionId = EducacionId.of("yyyy");
        TarjetaProfesional tarjetaProfesional = new TarjetaProfesional("y",true);
        Tipo tipo = new Tipo("Tecnico");
        Estudio estudio = new Estudio("Sistemas");
        Institucion institucion = new Institucion("Politecnico JIC");
        Periodo periodo = new Periodo("6");

        var command = new AgregarNuevaEducacion(gestionEducacionId,educacionId,tarjetaProfesional,tipo,estudio,institucion,periodo);
        var useCase = new AgregarEducacionUseCase();

        when(repository.getEventsBy(gestionEducacionId.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(gestionEducacionId.toString())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        var event = (NuevaEducacionAgregada) events.getDomainEvents().get(0);
        Assertions.assertEquals("y", event.getTarjetaProfesional().value().respuesta());
        Assertions.assertEquals("Tecnico", event.getTipo().value());
        Assertions.assertEquals("Sistemas", event.getEstudio().value());
        Assertions.assertEquals("Politecnico JIC", event.getInstitucion().value());
        Assertions.assertEquals("6", event.getPeriodo().value());
    }

    @Test
    void agregarEducacionUse_errorTarjetaObligatoria(){
        GestionEducacionId gestionEducacionId = GestionEducacionId.of("xxxx");
        EducacionId educacionId = EducacionId.of("yyyy");
        TarjetaProfesional tarjetaProfesional = new TarjetaProfesional("n",false);
        Tipo tipo = new Tipo("Tecnico");
        Estudio estudio = new Estudio("Sistemas");
        Institucion institucion = new Institucion("Politecnico JIC");
        Periodo periodo = new Periodo("6");

        var command = new AgregarNuevaEducacion(gestionEducacionId,educacionId,tarjetaProfesional,tipo,estudio,institucion,periodo);
        var useCase = new AgregarEducacionUseCase();

        when(repository.getEventsBy(gestionEducacionId.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(gestionEducacionId.value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        });
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