package co.com.sofka.prefilProfesional.usecases.services;

import co.com.sofka.prefilProfesional.domain.experiencia.values.ExperienciaId;
import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;

public interface EnviarNotificacionService {
    Boolean enviarPerfil(String correo, String descripcion, PerfilId perfilId);
    Boolean enviarExperiencia(String correo, String descripcion, ExperienciaId experienciaId);
}
