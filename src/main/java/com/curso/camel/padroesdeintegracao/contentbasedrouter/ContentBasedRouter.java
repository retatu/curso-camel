package com.curso.camel.padroesdeintegracao.contentbasedrouter;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        
        from("file:data/padroesdeintegracao/"
                + "contentbasedrouter/input")
            .choice()
                .when(header("CamelFileName").endsWith(".csv"));
        
    }
    
}
