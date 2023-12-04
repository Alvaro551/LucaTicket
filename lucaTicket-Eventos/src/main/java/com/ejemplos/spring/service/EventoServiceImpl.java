package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.repository.EventoRepository;


@Service
public class EventoServiceImpl implements EventoService{

	 @Autowired
	    private EventoRepository eventoRepository;

	    @Override
	    public List<Eventos> findAll() {
	        return eventoRepository.findAll();
	    }

		@Override
		public Optional<Eventos> buscarEventoPorId(Integer id) {
			
			return eventoRepository.findById(id);
		}

		

}
