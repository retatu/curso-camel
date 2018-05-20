package com.curso.camel.conversaodedados;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@CsvRecord(separator = ",", skipFirstLine = true, 
        generateHeaderColumns = true)
public class Curso {
    @DataField(pos = 1)
    @XmlElement(name = "ministrante")
    private String ministrate;
    @DataField(pos = 2)
    @XmlElement(name = "assunto")
    private String assunto;
    @DataField(pos = 3)
    @XmlElement(name = "local")
    private String local;
    @DataField(pos = 4)
    @XmlElement(name = "horas")
    private byte horas;

    @Override
    public String toString() {
        return "Curso{" + "ministrate=" + ministrate +
                ", assunto=" + assunto + ", local=" + local + 
                ", horas=" + horas + '}';
    }

    public String getMinistrate() {
        return ministrate;
    }

    public void setMinistrate(String ministrate) {
        this.ministrate = ministrate;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public byte getHoras() {
        return horas;
    }

    public void setHoras(byte horas) {
        this.horas = horas;
    }
    
    
}
