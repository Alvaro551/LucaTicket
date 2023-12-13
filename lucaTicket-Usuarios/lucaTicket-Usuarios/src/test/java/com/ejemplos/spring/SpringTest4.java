package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Usuario;
import com.ejemplos.spring.repository.UsuariosRepository;
import com.ejemplos.spring.response.UsuarioResponse;
import com.ejemplos.spring.services.UsuarioService;

@SpringBootTest
public class SpringTest4 {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuariosRepository usuarioRepository;

    @Test
    void obtenerUsuariosShouldReturnListOfUsuarioResponse() {
        // Arrange: Save a user to the repository
        Usuario usuario = new Usuario();
        // Set user properties
        usuarioRepository.save(usuario);

        // Act: Call the service method
        List<Usuario> usuarioResponses = usuarioService.findAll();

        // Assert: Check if the response contains a non-empty list of UsuarioResponse
        assertThat(usuarioResponses).isNotNull();
        assertThat(usuarioResponses).isNotEmpty();
        // Perform additional assertions based on the actual response structure
    }
}
