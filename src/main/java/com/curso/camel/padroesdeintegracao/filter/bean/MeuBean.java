/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.camel.padroesdeintegracao.filter.bean;

import com.curso.camel.Curso;
import org.apache.camel.Exchange;

/**
 *
 * @author Pichau
 */
public class MeuBean {
    public boolean verificaHorasDoCurso(Exchange exchange){
        Curso curso = exchange.getIn().getBody(Curso.class);
        
        return curso.getHoras() >= 3;
    }
}
