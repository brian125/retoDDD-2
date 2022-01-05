package co.com.sofka.prefilProfesional.usecases.porcomandos.perfil;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.prefilProfesional.domain.generics.HojaDeVidaId;
import co.com.sofka.prefilProfesional.domain.generics.Institucion;
import co.com.sofka.prefilProfesional.domain.generics.Periodo;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.GestionEducacionCreada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.EducacionId;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.Estudio;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.TarjetaProfesional;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.Tipo;
import co.com.sofka.prefilProfesional.domain.perfil.commands.CrearPerfil;
import co.com.sofka.prefilProfesional.domain.perfil.events.PerfilCreado;
import co.com.sofka.prefilProfesional.domain.perfil.values.FotoPerfil;
import co.com.sofka.prefilProfesional.domain.perfil.values.InformacionContacto;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearPerfilUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void crearPerfilUseCaseTest(){
        //Arrange
        PerfilId perfilId = PerfilId.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");
        InformacionContacto informacionContacto = new InformacionContacto("3001112233");
        FotoPerfil fotoPerfil = new FotoPerfil("https://mipath.com");

        var command = new CrearPerfil(perfilId, hojaDeVidaId, informacionContacto, fotoPerfil);
        var useCase = new CrearPerfilUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts
        PerfilCreado event = (PerfilCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("cvxxx", event.getHojaDeVidaId().value());
        Assertions.assertEquals("3001112233", event.getInformacionContacto().value());
        Assertions.assertEquals("https://mipath.com", event.getFotoPerfil().value());
    }

    @Test
    void crearPerfil_errorFotoDePerfil(){
        //Arrange
        PerfilId perfilId = PerfilId.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");
        InformacionContacto informacionContacto = new InformacionContacto("3001112233");
        FotoPerfil fotoPerfil = new FotoPerfil("C:/Users/123/fotoperfil");

        var command = new CrearPerfil(perfilId, hojaDeVidaId, informacionContacto, fotoPerfil);
        var useCase = new CrearPerfilUseCase();

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(perfilId.value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        });
    }

}