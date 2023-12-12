package com.ejemplos.spring.model;

public class PagoYEntradaResponse {
	
	private RespuestaPago respuestaPago;
    private Entrada entrada;
	public RespuestaPago getRespuestaPago() {
		return respuestaPago;
	}
	public void setRespuestaPago(RespuestaPago respuestaPago) {
		this.respuestaPago = respuestaPago;
	}
	public Entrada getEntrada() {
		return entrada;
	}
	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}
    
    
}
