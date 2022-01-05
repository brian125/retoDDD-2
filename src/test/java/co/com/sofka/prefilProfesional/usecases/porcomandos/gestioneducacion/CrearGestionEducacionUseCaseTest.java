package co.com.sofka.prefilProfesional.usecases.porcomandos.gestioneducacion;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.prefilProfesional.domain.experiencia.commands.CrearExperiencia;
import co.com.sofka.prefilProfesional.domain.experiencia.events.ExperienciaCreada;
import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaId;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.commands.CrearGestionEducacion;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.GestionEducacionCreada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.GestionEducacionId;
import co.com.sofka.prefilProfesional.usecases.porcomandos.experiencia.CrearExperienciaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearGestionEducacionUseCaseTest {

    @Test
    void crearGestionEducacionUseCaseTest() {
        //Arrange
        GestionEducacionId gestionEducacionId = GestionEducacionId.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");

        var command = new CrearGestionEducacion(gestionEducacionId, hojaDeVidaId);
        var useCase = new CrearGestionEducacionUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts
        GestionEducacionCreada event = (GestionEducacionCreada) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("cvxxx", event.getHojaDeVidaId().value());
    }

}