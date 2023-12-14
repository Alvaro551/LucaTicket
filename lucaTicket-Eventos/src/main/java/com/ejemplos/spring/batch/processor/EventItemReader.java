package com.ejemplos.spring.batch.processor;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.opencsv.CSVReader;

public class EventItemReader implements ItemReader<String[]>{

	CSVReader csvReader;
	
	public EventItemReader() {
		try {
			csvReader = new CSVReader(new FileReader("cargacsv.csv"));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String[] read()throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		if(csvReader.getLinesRead() == 0) {
			csvReader.readNext();
		}
		
		String[] values = csvReader.readNext();
		
		if(values != null) {
			for(String string: values) {
				System.out.println(string + ",");
			}
		}else {
			System.out.println("Valores leídos correctamente");
		}
		System.out.println();
		
		return values;
	}

}
