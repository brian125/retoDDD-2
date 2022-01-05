package co.com.sofka.prefilProfesional.usecases.porcomandos.experiencia;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.experiencia.commands.ActualizarExperienciaLaboralPeriodo;
import co.com.sofka.prefilProfesional.domain.experiencia.events.ExperienciaCreada;
import co.com.sofka.prefilProfesional.domain.experiencia.events.NuevaExperienciaLaboralAgregada;
import co.com.sofka.prefilProfesional.domain.experiencia.events.PeriodoExperinciaLaboralActualizado;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaId;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaLaboralId;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ActualizarExperienciaLaboralPeriodoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarExperienciaLaboralPeriodoUseCaseTest() {
        //Arrange
        ExperienciaId experienciaId;
        experienciaId = ExperienciaId.of("1");

        ExperienciaLaboralId experienciaLaboralId;
        experienciaLaboralId = ExperienciaLaboralId.of("xxxx");

        var command = new ActualizarExperienciaLaboralPeriodo(experienciaId, experienciaLaboralId, new Periodo("3"));
        var useCase = new ActualizarExperienciaLaboralPeriodoUseCase();

        //Act
        when(repository.getEventsBy(experienciaId.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(experienciaId.toString())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Assert
        var event =  (PeriodoExperinciaLaboralActualizado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.getExperienciaLaboralId().value());
        Assertions.assertEquals("3", event.getPeriodo().value());
    }

    @Test
    void actualizarExperienciaLaboralPeriodo_errorPeriodoMuyLargo() {
        //Arrange
        ExperienciaId experienciaId;
        experienciaId = ExperienciaId.of("1");

        ExperienciaLaboralId experienciaLaboralId;
        experienciaLaboralId = ExperienciaLaboralId.of("xxxx");

        var command = new ActualizarExperienciaLaboralPeriodo(experienciaId, experienciaLaboralId, new Periodo("1000"));
        var useCase = new ActualizarExperienciaLaboralPeriodoUseCase();

        //Act
        when(repository.getEventsBy(experienciaId.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(experienciaId.value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        });
    }

    private List<DomainEvent> eventList(){
        return List.of(new ExperienciaCreada(new HojaDeVidaId("cvxxx")),
                new NuevaExperienciaLaboralAgregada(ExperienciaLaboralId.of("xxxx"),
                new Institucion("Play the kids"),
                new Periodo("1"),
                new ConocimientosAdquiridos("Asesor ventas")
        ));
    }

}