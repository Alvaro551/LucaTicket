package com.ejemplos.spring.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Operative {

    @XmlElement(name = "RDR_Code_Operative")
    private String rdrCodeOperative;

    @XmlElement(name = "RDR_Code_Operative_Source")
    private String rdrCodeOperativeSource;


    @XmlElement(name = "SUBDIVISIONS")
    private Subdivisions subdivisions;


    public Subdivisions getSubdivisions() {
        return subdivisions;
    }

    public void setSubdivisions(Subdivisions subdivisions) {
        this.subdivisions = subdivisions;
    }
}
