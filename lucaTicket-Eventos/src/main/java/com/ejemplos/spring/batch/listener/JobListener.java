package com.ejemplos.spring.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobListener implements JobExecutionListener{
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.STARTED) {
			System.out.println("Ejecutando trabajo con id: "+jobExecution.getId());
		}
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("Terminando trabajo con id: "+ jobExecution.getId());
		}
	}

}
