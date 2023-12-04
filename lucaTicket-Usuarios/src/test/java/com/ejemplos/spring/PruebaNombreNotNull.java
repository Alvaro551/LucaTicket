package com.ejemplos.spring;
import com.ejemplos.spring.controller.UsuariosController;
import com.ejemplos.spring.model.Usuario;
import com.ejemplos.spring.repository.UsuariosRepository;
import com.ejemplos.spring.response.UsuarioResponse;
import com.ejemplos.spring.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PruebaNombreNotNull {

    @Autowired
    private UsuariosController usuariosController;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuariosRepository usuarioRepository;

    @Test
    @Transactional
    public void testAddUsuariosWithEmptyFields() {
        // Arrange
        Usuario usuarioConCamposVacios = new Usuario(); // Asume que todos los campos son nulos o vacíos

        // Act
        ResponseEntity<UsuarioResponse> response = usuariosController.addUsuarios(usuarioConCamposVacios);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    @Transactional
    public void testAddUsuariosWithNonEmptyFields() {
        // Arrange
        Usuario usuarioConDatos = new Usuario(); // Asume que se proporcionan datos válidos

        // Act
        ResponseEntity<UsuarioResponse> response = usuariosController.addUsuarios(usuarioConDatos);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        // Agrega más aserciones según tu lógica de respuesta
    }

    @Test
    public void testObtenerUsuarios() {
        // Arrange
        Usuario usuario1 = new Usuario(); // Asume que tienes al menos un usuario en la base de datos
        usuarioRepository.save(usuario1);

        // Act
        List<UsuarioResponse> usuarios = usuariosController.obtenerUsuarios();

        // Assert
        assertFalse(usuarios.isEmpty());
        // Agrega más aserciones según tu lógica de respuesta
    }
}
