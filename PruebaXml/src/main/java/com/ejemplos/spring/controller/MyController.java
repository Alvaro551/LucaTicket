package com.ejemplos.spring.controller;

import com.ejemplos.spring.xml.GlobalObject;
import com.ejemplos.spring.xml.Globals;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MyController {

	@RestController
	public class XmlController {

		@PostMapping("/xml-file-to-object")
		public ResponseEntity<Globals> handleXmlFile(@RequestPart("file") MultipartFile file) {
		    try {
		        // Leer el contenido XML del archivo
		        String xmlContent = new String(file.getBytes(), StandardCharsets.UTF_8);

		        // Procesar el contenido XML y convertirlo a Globals
		        Globals globals = processXml(xmlContent);

		        // Devolver la instancia de Globals procesada
		        return new ResponseEntity<>(globals, HttpStatus.OK);
		    } catch (IOException e) {
		        e.printStackTrace();
		        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		}

		private Globals processXml(String xmlContent) {
		    try {
		        JAXBContext jaxbContext = JAXBContext.newInstance(Globals.class);
		        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		        // Deserializar el contenido XML en una instancia de Globals
		        StringReader reader = new StringReader(xmlContent);
		        return (Globals) unmarshaller.unmarshal(reader);
		    } catch (JAXBException e) {
		        e.printStackTrace(); // Registrar los detalles de la excepción
		        throw new RuntimeException("Error al procesar XML: " + e.getMessage(), e);
		    }
		}
	}

}
