package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringTest01 {
	
	 //Debería acertar aposta
  	@Test
  	void shouldBeAlwaysTrue() {
  		//El assertThat es de AssertJ
  		assertThat(true).isTrue();
  	}
}
