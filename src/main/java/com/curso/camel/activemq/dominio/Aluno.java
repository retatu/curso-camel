package com.curso.camel.activemq.dominio;

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
public class Aluno {
    
    @DataField(pos = 1)
    @XmlElement(name = "nome")
    private String nome;
    @DataField(pos = 2)
    @XmlElement(name = "idade")
    private byte idade;
    @DataField(pos = 3)
    @XmlElement(name = "rg")
    private int rg;
    @DataField(pos = 4)
    @XmlElement(name = "semestre")
    private byte semestre;

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", idade=" + idade + ", rg=" + rg + ", semestre=" + semestre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + this.idade;
        hash = 43 * hash + this.rg;
        hash = 43 * hash + this.semestre;
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
        final Aluno other = (Aluno) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (this.rg != other.rg) {
            return false;
        }
        if (this.semestre != other.semestre) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte getIdade() {
        return idade;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public byte getSemestre() {
        return semestre;
    }

    public void setSemestre(byte semestre) {
        this.semestre = semestre;
    }
}
