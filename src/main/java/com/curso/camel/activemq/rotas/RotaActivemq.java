package com.curso.camel.activemq.rotas;

import org.apache.camel.builder.RouteBuilder;

public class RotaActivemq extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        
        from("activemq:queue:minhaFila")
            .log("Headers: ${headers}, body: ${body}")
                .to("mock:output");
        
    }   
}
