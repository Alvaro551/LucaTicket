package com.ejemplos.spring.batch.processor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.batch.item.ItemProcessor;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.model.Recinto;


public class EventItemProcessor implements ItemProcessor<String[],Eventos>{
	
	@Override
	public Eventos process(String[] item) throws Exception {
		
		System.out.println("Procesando dato: "+Integer.parseInt(item[0]));
		return Eventos.builder()
				.id(Integer.parseInt(item[0]))
				.nombre(item[5])
				.descripcioncorta(item[4])
				.descripcionextendida(item[6])
				.foto(null)
				.fechaevento(LocalDate.now())
				.horaevento(LocalDateTime.now())
				.preciomin(0)
				.preciomax(100)
				.normas(null)
				.genero("Variado")
				.recinto(new Recinto(7L))
				.build();
	}

}


