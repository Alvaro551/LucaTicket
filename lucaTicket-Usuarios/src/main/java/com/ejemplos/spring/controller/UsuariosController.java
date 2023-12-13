package com.ejemplos.spring.controller;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.model.CustomResponse;
import com.ejemplos.spring.model.Usuario;
import com.ejemplos.spring.model.UsuarioRequest;
import com.ejemplos.spring.repository.UsuariosRepository;
import com.ejemplos.spring.response.UsuarioResponse;
import com.ejemplos.spring.response.UsuarioResponseADD;
import com.ejemplos.spring.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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
	 * @return ResponseEntity con la lista de UsuarioResponse y el código de estado
	 *         correspondiente.
	 */
	@GetMapping
	public ResponseEntity<CustomResponse<List<UsuarioResponse>>> obtenerUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioResponse> usuarioResponses = usuarios.stream().map(UsuarioResponse::of)
				.collect(Collectors.toList());
		return ResponseEntity.ok(CustomResponse.createSuccessResponse(usuarioResponses));
	}

	/**
	 * Agrega un nuevo usuario.
	 *
	 * @param nuevoUsuario El nuevo usuario a agregar.
	 * @return ResponseEntity con el UsuarioResponse del usuario agregado y el
	 *         código de estado correspondiente.
	 */
	@PostMapping
	@Operation(summary = "Añadir un nuevo usuario", description = "Crea y guarda un nuevo usuario en la base de datos")
	@ApiResponses(value = { 
	    @ApiResponse(responseCode = "201", description = "Usuario creado con éxito"),
	    @ApiResponse(responseCode = "400", description = "Solicitud inválida si los datos del usuario no son correctos"),
	    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
	})
	public ResponseEntity<CustomResponse<UsuarioResponseADD>> addUsuario(@RequestBody UsuarioRequest nuevoUsuarioRequest) {
	    Usuario nuevoUsuario = nuevoUsuarioRequest.transformToUsuario();
	    Usuario usuarioGuardado = usuarioService.addUsuario(nuevoUsuario);
	    return ResponseEntity.status(HttpStatus.CREATED)
	                         .body(CustomResponse.createSuccessResponse(UsuarioResponseADD.of(usuarioGuardado)));
	}

	

	/**
	 * Borra un usuario por su ID.
	 *
	 * @param id El identificador único del Usuario a borrar.
	 * @return ResponseEntity con el CustomResponse que contiene el usuario antes de
	 *         ser borrado y el código de estado correspondiente.
	 */
	@DeleteMapping("/{id}")
	@Operation(summary = "Borrar un usuario por ID", description = "Elimina un usuario de la base de datos basado en su ID")
	@ApiResponse(responseCode = "200", description = "Usuario eliminado con éxito")
	public ResponseEntity<CustomResponse<UsuarioResponseADD>> borrarUsuarioPorId(@PathVariable Integer id) {
		try {
			// Intenta obtener el usuario antes de borrarlo
			Usuario usuarioAntes = usuarioService.findById(id);

			// Intenta borrar el usuario
			boolean borradoExitoso = usuarioService.borrarUsuarioPorId(id);

			if (borradoExitoso) {
				return ResponseEntity.ok(CustomResponse.createSuccessResponse(UsuarioResponseADD.of(usuarioAntes)));
			} else {
				// Si el usuario no existe o no pudo ser borrado
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(CustomResponse.createNotFoundResponse("Usuario no encontrado"));
			}
		} catch (DateTimeParseException e) {
			// Manejar la excepción de formato de fecha incorrecto
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(CustomResponse.createBadRequestResponse("Formato de fecha incorrecto"));
		} catch (Exception e) {
			// Manejar otras excepciones inesperadas
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(CustomResponse.createInternalServerErrorResponse("Error interno al borrar el usuario"));
		}
	}

	/**
	 * Edita un usuario por su ID.
	 *
	 * @param id           El identificador único del Usuario a editar.
	 * @param usuarioNuevo El usuario con los datos actualizados.
	 * @return ResponseEntity con el CustomResponse que contiene el usuario
	 *         actualizado y el código de estado correspondiente.
	 */
	@PutMapping("/{id}")
	@Operation(summary = "Editar un usuario por ID", description = "Actualiza un usuario en la base de datos basado en su ID")
	@ApiResponse(responseCode = "200", description = "Usuario editado con éxito")
	public ResponseEntity<CustomResponse<UsuarioResponseADD>> editarUsuario(@PathVariable("id") Integer id,
			@RequestBody UsuarioRequest usuarioNuevoRequest) {
		try {
			Usuario usuarioNuevo = usuarioNuevoRequest.transformToUsuario();
			Usuario usuarioEditado = usuarioService.editarUsuario(id, usuarioNuevo);

			if (usuarioEditado != null) {
				return ResponseEntity.ok(CustomResponse.createSuccessResponse(UsuarioResponseADD.of(usuarioEditado)));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(CustomResponse.createNotFoundResponse("Usuario no existente"));
			}
		} catch (DateTimeParseException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(CustomResponse.createBadRequestResponse("Formato de fecha incorrecto"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(CustomResponse.createInternalServerErrorResponse("Error interno al editar el usuario"));
		}
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Obtener un usuario por ID", description = "Recupera un usuario de la base de datos basado en su ID")
	@ApiResponse(responseCode = "200", description = "Usuario encontrado con éxito")
	@ApiResponse(responseCode = "404", description = "Usuario no encontrado")
	public ResponseEntity<CustomResponse<UsuarioResponseADD>> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
	    try {
	        Usuario usuario = usuarioService.findById(id);

	        if (usuario != null) {
	            return ResponseEntity.ok(CustomResponse.createSuccessResponse(UsuarioResponseADD.of(usuario)));
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body(CustomResponse.createNotFoundResponse("Usuario no encontrado con ID: " + id));
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(CustomResponse.createInternalServerErrorResponse("Error interno al obtener el usuario"));
	    }
	}
}
