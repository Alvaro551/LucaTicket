package com.ejemplos.spring.xml;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Locals {

    @XmlElement(name = "LOCAL")
    private List<Local> local;

    public List<Local> getLocal() {
        return local;
    }

    public void setLocal(List<Local> local) {
        this.local = local;
    }
}

