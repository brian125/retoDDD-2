package co.com.sofka.prefilProfesional.usecases.services;

import co.com.sofka.prefilProfesional.domain.gestioneducacion.Educacion;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.Estudio;
import co.com.sofka.prefilProfesional.domain.gestioneducacion.values.GestionEducacionId;

public interface FiltrarService {
    Boolean filtrar(Estudio busqueda,Estudio buscado, GestionEducacionId gestionEducacionId);
}
