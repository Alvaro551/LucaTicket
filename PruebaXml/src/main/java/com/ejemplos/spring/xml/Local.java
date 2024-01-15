package com.ejemplos.spring.xml;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class Local {

	@XmlElement(name = "RDR_Code_Local")
	private String rdrCodeLocal;

	@XmlElement(name = "RDR_Code_Local_Source")
	private String rdrCodeLocalSource;

	@XmlElement(name = "Entity_Name")
	private String entityName;

	// Otros campos y clases anidadas según sea necesario

	@XmlElement(name = "Last_Changed_User")
	private String lastChangedUser;

	public String getRdrCodeLocal() {
		return rdrCodeLocal;
	}

	public void setRdrCodeLocal(String rdrCodeLocal) {
		this.rdrCodeLocal = rdrCodeLocal;
	}

	public String getRdrCodeLocalSource() {
		return rdrCodeLocalSource;
	}

	public void setRdrCodeLocalSource(String rdrCodeLocalSource) {
		this.rdrCodeLocalSource = rdrCodeLocalSource;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getLastChangedUser() {
		return lastChangedUser;
	}

	public void setLastChangedUser(String lastChangedUser) {
		this.lastChangedUser = lastChangedUser;
	}

	

}
