package com.ejemplos.spring.adapter;

import com.ejemplos.spring.model.Usuario;
import com.ejemplos.spring.response.UsuarioResponse;

/**
 * Clase de adaptación que convierte un objeto Usuario en un objeto UsuarioResponse.
 */
public class UsuarioAdapter {

    /**
     * Convierte un objeto Usuario en un objeto UsuarioResponse.
     *
     * @param usuario El objeto Usuario a adaptar.
     * @return Un objeto UsuarioResponse adaptado.
     */
    public static UsuarioResponse adaptarUsuario(Usuario usuario) {
        return UsuarioResponse.of(usuario);
    }
}
