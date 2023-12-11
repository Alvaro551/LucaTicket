package com.ejemplos.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejemplos.spring.model.CustomResponse;
import com.ejemplos.spring.model.Usuario;
import com.ejemplos.spring.model.UsuarioRequest;
import com.ejemplos.spring.repository.UsuariosRepository;
import com.ejemplos.spring.response.UsuarioResponse;
import com.ejemplos.spring.services.UsuarioService;

/**
 * Controlador para gestionar las operaciones relacionadas con usuarios.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuariosRepository usuarioRepository;

    /**
     * Obtiene todos los usuarios.
     *
     * @return ResponseEntity con la lista de UsuarioResponse y el código de estado correspondiente.
     */
    @GetMapping
    public ResponseEntity<CustomResponse<List<UsuarioResponse>>> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponse> usuarioResponses = usuarios.stream()
                                                         .map(UsuarioResponse::of)
                                                         .collect(Collectors.toList());
        return ResponseEntity.ok(CustomResponse.createSuccessResponse(usuarioResponses));
    }

    /**
     * Agrega un nuevo usuario.
     *
     * @param nuevoUsuario El nuevo usuario a agregar.
     * @return ResponseEntity con el UsuarioResponse del usuario agregado y el código de estado correspondiente.
     */
    @PostMapping
    public ResponseEntity<CustomResponse<UsuarioResponse>> addUsuario(@RequestBody UsuarioRequest nuevoUsuarioRequest) {
        try {
            Usuario nuevoUsuario = nuevoUsuarioRequest.transformToUsuario();
            Usuario usuarioGuardado = usuarioService.addUsuario(nuevoUsuario);
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body(CustomResponse.createSuccessResponse(UsuarioResponse.of(usuarioGuardado)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(CustomResponse.createInternalServerErrorResponse("Error al crear el usuario"));
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Usuario>> buscarUsuarioPorId(@PathVariable Integer id) {
        try {
            Usuario usuario = usuarioService.findById(id);
            if (usuario != null) {
                return ResponseEntity.ok(CustomResponse.createSuccessResponse(usuario));
            } else {
                // Si el usuario no existe
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(CustomResponse.createNotFoundResponse("Usuario no encontrado"));
            }
        } catch (Exception e) {
            // Manejar otras excepciones inesperadas
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomResponse.createInternalServerErrorResponse("Error interno al buscar el usuario"));
        }
    }
    
    
}

