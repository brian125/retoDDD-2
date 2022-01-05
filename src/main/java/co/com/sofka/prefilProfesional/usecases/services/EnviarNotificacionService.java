package co.com.sofka.prefilProfesional.usecases.services;

import co.com.sofka.prefilProfesional.domain.perfil.values.PerfilId;

public interface EnviarNotificacionService {
    boolean enviar(String correo, String descripcion, PerfilId perfilId);
}
