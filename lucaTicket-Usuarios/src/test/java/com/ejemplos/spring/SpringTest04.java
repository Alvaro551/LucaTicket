package com.ejemplos.spring;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ejemplos.spring.repository.UsuariosRepository;
import com.ejemplos.spring.services.UsuarioService;

@SpringBootTest
public class SpringTest04 {
	

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuariosRepository usuarioRepository;
	
	boolean cierto;
	
	@Test
	void shoudBeThereId() {
		int id = 2;
		//Primero intento borrar un Evento
		usuarioService.borrarUsuarioPorId(id);
		// Si este método es true, entonces no lo está borrando y por tanto está
		// recibiendo un id diferente
		if(usuarioRepository.existsById(id)) {
			cierto = false;
		}else {
			cierto = true;
		}
		
		assertThat(cierto).isTrue();
		
	}
	
}
