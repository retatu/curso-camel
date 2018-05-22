package com.curso.camel.padroesdeintegracao.spliter;

import org.apache.camel.builder.RouteBuilder;

public class Spliter extends RouteBuilder{
    @Override
    public void configure() throws Exception {  
        from("file:data/padroesdeintegracao/spliter/"
            + "input?noop=true")
            .filter(header("CamelFileName")
                    .endsWith(".csv")) // trocar para xml
                        .split().tokenize("\n", false, true)
                            .split().tokenize(",")
                        //.split().tokenizeXML("ministrante")
                            .log("Após 'splitar', o body é ${body}"
                                + " e os headers são ${headers}")
        .to("file:data/padroesdeintegracao/spliter/output/csv");
    } 
}
