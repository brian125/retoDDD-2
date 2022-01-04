package co.com.sofka.prefilProfesional.domain.perfil;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.prefilProfesional.domain.perfil.events.NombreCompletoReferenciaActualizado;
import co.com.sofka.prefilProfesional.domain.perfil.events.NuevaReferenciaAgregada;
import co.com.sofka.prefilProfesional.domain.perfil.events.PerfilCreado;


import java.util.HashSet;

public class PerfilChange extends EventChange {
    public PerfilChange(Perfil perfil) {

        apply((PerfilCreado event)->{
            perfil.hojaDeVidaId = event.getHojaDeVidaId();
            perfil.informacionContacto = event.getInformacionContacto();
            perfil.fotoPerfil = event.getFotoPerfil();
        });

        apply((NuevaReferenciaAgregada event)->{
            perfil.referencia = new Referencia(
                    event.getReferenciaId(),
                    event.getCedula(),
                    event.getInformacionContacto(),
                    event.getNombreCompleto()
            );
        });

        apply((NombreCompletoReferenciaActualizado event)->{
            perfil.referencia.nombreCompleto = event.getNombreCompleto();
        });

    }
}
