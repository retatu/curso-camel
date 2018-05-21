/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.camel.conversaodedados.marshal;

import com.curso.camel.conversaodedados.marshal.process.MyProcessor;
import com.curso.camel.Curso;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.jacksonxml.JacksonXMLDataFormat;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

/**
 *
 * @author Pichau
 */
public class Marshal extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        DataFormat dataFormat =
//                 new BindyCsvDataFormat(Curso.class);
//                 new GsonDataFormat(Curso.class);
                new JacksonXMLDataFormat(Curso.class);

        from("timer:?period=16s")
                .process(new MyProcessor())
                .log("A mensagem é: ${body}")
                .marshal(dataFormat)
                .log("Depois do marshal a mensagem é: ${body}")
                .to("file:data/conversaodedados/marshal/xml/output?"
                        + "fileName=file.xml");
    }
}
