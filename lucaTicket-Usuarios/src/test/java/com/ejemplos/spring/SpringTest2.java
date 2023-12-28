package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Usuario;
import com.ejemplos.spring.repository.UsuariosRepository;
import com.ejemplos.spring.services.UsuarioService;

@SpringBootTest
public class SpringTest2 {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuariosRepository usuarioRepository;

    @Test
    void shouldEditUser() {
        // Crear un usuario existente en la base de datos (asegúrate de que este usuario ya exista)
        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setNombre("NombreExistente");
        usuarioExistente.setApellido("ApellidoExistente");
        usuarioExistente.setMail("existentemail@example.com");
        usuarioExistente.setContrasena("contrasenaExistente");
        usuarioExistente.setFechaAlta(LocalDate.parse("2022-01-01"));

        usuarioRepository.save(usuarioExistente);

        // Crear un usuario nuevo con valores actualizados
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setNombre("NuevoNombre");
        usuarioNuevo.setApellido("NuevoApellido");
        usuarioNuevo.setMail("nuevoemail@example.com");
        usuarioNuevo.setContrasena("nuevaContrasena");
        usuarioNuevo.setFechaAlta(LocalDate.parse("2022-01-02"));

        // Obtener el ID del usuario existente
        Integer idUsuario = usuarioExistente.getUsuarioID();

        // Act
        Usuario usuarioActualizado = usuarioService.editarUsuario(idUsuario, usuarioNuevo);

        // Assert
        assertThat(usuarioActualizado).isNotNull();
        assertThat(usuarioActualizado.getNombre()).isEqualTo(usuarioNuevo.getNombre());
        assertThat(usuarioActualizado.getApellido()).isEqualTo(usuarioNuevo.getApellido());
        assertThat(usuarioActualizado.getMail()).isEqualTo(usuarioNuevo.getMail());
        assertThat(usuarioActualizado.getContrasena()).isEqualTo(usuarioNuevo.getContrasena());
        assertThat(usuarioActualizado.getFechaAlta()).isEqualTo(usuarioNuevo.getFechaAlta());
    }
}
