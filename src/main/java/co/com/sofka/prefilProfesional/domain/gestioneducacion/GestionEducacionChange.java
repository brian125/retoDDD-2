package co.com.sofka.prefilProfesional.domain.gestioneducacion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.GestionEducacionCreada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.events.TipoEducacionActualizada;

public class GestionEducacionChange extends EventChange {
    public GestionEducacionChange(GestionEducacion gestionEducacion) {

        apply((GestionEducacionCreada event)->{
            gestionEducacion.hojaDeVidaId = event.getHojaDeVidaId();
        });

        apply((NuevaEducacionAgregada event)->{
            gestionEducacion.educacion = new Educacion(
                    event.getId(),
                    event.getTarjetaProfesional(),
                    event.getTipo(),
                    event.getEstudio(),
                    event.getInstitucion(),
                    event.getPeriodo()
            );
        });

        apply((TipoEducacionActualizada event)->{
            gestionEducacion.educacion.tipo = event.getTipo();
        });

    }
}
