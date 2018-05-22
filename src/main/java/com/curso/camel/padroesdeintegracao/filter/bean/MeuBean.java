package com.curso.camel.padroesdeintegracao.filter.bean;

import com.curso.camel.Curso;
import org.apache.camel.Exchange;

public class MeuBean {
    public boolean verificaHorasDoCurso(Exchange exchange){
        Curso curso = exchange.getIn().getBody(Curso.class);
        
        return curso.getHoras() >= 3;
    }
}
