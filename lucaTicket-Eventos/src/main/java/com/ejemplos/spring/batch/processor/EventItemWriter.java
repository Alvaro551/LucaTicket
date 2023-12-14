package com.ejemplos.spring.batch.processor;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.repository.EventoRepository;

@Component
public class EventItemWriter implements ItemWriter<Eventos>{
	
	EventoRepository repository;
	
	@Autowired
	public EventItemWriter(EventoRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void write(Chunk<? extends Eventos> chunk) throws Exception {		
		repository.saveAll(chunk);
	}

}
