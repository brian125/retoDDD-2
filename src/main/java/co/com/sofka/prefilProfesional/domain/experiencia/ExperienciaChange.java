package co.com.sofka.prefilProfesional.domain.experiencia;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.prefilProfesional.domain.experiencia.events.ExperienciaCreada;
import co.com.sofka.prefilProfesional.domain.experiencia.events.NuevaExperienciaLaboralAgregada;
import co.com.sofka.prefilProfesional.domain.experiencia.events.PeriodoExperinciaLaboralActualizado;


public class ExperienciaChange extends EventChange {
    public ExperienciaChange(Experiencia experiencia) {

        apply((ExperienciaCreada event)->{
            experiencia.hojaDeVidaId = event.getHojaDeVidaId();
        });

        apply((NuevaExperienciaLaboralAgregada event)->{
            experiencia.experienciaLaboral = new ExperienciaLaboral(
                    event.getId(),
                    event.getInstitucion(),
                    event.getPeriodo(),
                    event.getConocimientosAdquiridos()
            );
        });

        apply((PeriodoExperinciaLaboralActualizado event)->{
            experiencia.experienciaLaboral.periodo= event.getPeriodo();
        });


    }
}
