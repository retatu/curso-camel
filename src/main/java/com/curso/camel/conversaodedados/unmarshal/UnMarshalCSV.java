package com.curso.camel.conversaodedados.unmarshal;

import com.curso.camel.conversaodedados.Curso;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.component.jacksonxml.JacksonXMLDataFormat;
import org.apache.camel.spi.DataFormat;

public class UnMarshalCSV extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        DataFormat dataFormat = 
                new BindyCsvDataFormat(Curso.class);
//        DataFormat dataFormat = 
//                new GsonDataFormat(Curso.class);
//        DataFormat dataFormat = 
//                new JacksonXMLDataFormat(Curso.class);
        
        from("file:data/conversaodedados/unmarshal/csv/input?noop=true")
                .log("A mensagem é: ${body}")
                .unmarshal(dataFormat)
                .log("Depois do unmarshal a mensagem é: ${body}")
                .to("mock:output");
    }
}
