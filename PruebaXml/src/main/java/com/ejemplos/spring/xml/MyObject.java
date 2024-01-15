package com.ejemplos.spring.xml;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyObject {

	private String property1;
	private int property2;

	@XmlElement
	public String getProperty1() {
		return property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	@XmlElement
	public int getProperty2() {
		return property2;
	}

	public void setProperty2(int property2) {
		this.property2 = property2;
	}
}
