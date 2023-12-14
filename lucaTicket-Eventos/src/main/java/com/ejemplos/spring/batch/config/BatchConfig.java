package com.ejemplos.spring.batch.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.ejemplos.spring.batch.listener.JobListener;
import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.batch.processor.EventItemProcessor;
import com.ejemplos.spring.batch.processor.EventItemReader;
import com.ejemplos.spring.batch.processor.EventItemWriter;

@Configuration
public class BatchConfig {
	
	@Autowired
	EventItemWriter eventoWriter;
	
	@Bean
	public Job procesoLotes(JobExecutionListener listener, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new JobBuilder("procesoLotes",jobRepository)
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step01(jobRepository,transactionManager))
				.end()
				.build();
	}
	
	@Bean
	public Step step01(JobRepository jobRepository, PlatformTransactionManager transactionManager ) {
		return new StepBuilder("step01",jobRepository)
				.<String[],Eventos>chunk(100, transactionManager)
				.reader(new EventItemReader())
				.processor(new EventItemProcessor())
				.writer(eventoWriter)
				.build();
	}
	
	@Bean
	public JobExecutionListener listener() {
		return new JobListener();
	}

}
