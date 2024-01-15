package com.ejemplos.spring.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "GLOBALS")
@XmlAccessorType(XmlAccessType.FIELD)
public class Globals {

    @XmlElement(name = "GLOBAL")
    private List<GlobalObject> globalObjects;

    public List<GlobalObject> getGlobalObjects() {
        return globalObjects;
    }

    public void setGlobalObjects(List<GlobalObject> globalObjects) {
        this.globalObjects = globalObjects;
    }
}


