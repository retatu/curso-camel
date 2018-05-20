/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.camel.conversaodedados.marshal.process;

import com.curso.camel.conversaodedados.Curso;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author Pichau
 */
public class MyProcessor implements Processor{
    @Override
    public void process(Exchange exchange) throws Exception {
        Curso curso = new Curso();
        curso.setMinistrate("Matheus Rehbein");
        curso.setAssunto("Apache Camel");
        curso.setLocal("Unijui");
        curso.setHoras((byte)3);
        
        exchange.getIn().setBody(curso);
    } 
}
