package com.ejemplos.spring.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Operatives {

    @XmlElement(name = "OPERATIVE")
    private Operative operative;

    // Getter y Setter para la propiedad

    public Operative getOperative() {
        return operative;
    }

    public void setOperative(Operative operative) {
        this.operative = operative;
    }
}
