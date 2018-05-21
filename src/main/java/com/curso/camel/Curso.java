package com.curso.camel;

import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.ministrate);
        hash = 97 * hash + Objects.hashCode(this.assunto);
        hash = 97 * hash + Objects.hashCode(this.local);
        hash = 97 * hash + this.horas;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (this.horas != other.horas) {
            return false;
        }
        if (!Objects.equals(this.ministrate, other.ministrate)) {
            return false;
        }
        if (!Objects.equals(this.assunto, other.assunto)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        return true;
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
