package com.ejemplos.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.model.Usuario;
import com.ejemplos.spring.repository.UsuariosRepository;
import com.ejemplos.spring.response.UsuarioResponse;
import com.ejemplos.spring.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuariosRepository usuarioRepository;
	
	@GetMapping
	public List<UsuarioResponse> obtenerUsuarios(){
		List<Usuario> usuario = usuarioRepository.findAll();
		return usuario.stream()
				.map(UsuarioResponse::of)
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public ResponseEntity<UsuarioResponse> addEvento(@RequestBody Usuario nuevoUsuario){
		Usuario usuarioGuardado = usuarioService.addUsuario(nuevoUsuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponse.of(usuarioGuardado));
	}
	
}
