package com.curso.camel.padroesdeintegracao.contentbasedrouter;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("file:data/padroesdeintegracao/"
                + "contentbasedrouter/input?noop=true")
            .choice()
                .when(header("CamelFileName").endsWith(".csv"))
                    .to("file:data/padroesdeintegracao/"
                + "contentbasedrouter/output/csv")
                .when(header("CamelFileName").endsWith(".xml"))
                    .to("file:data/padroesdeintegracao/"
                + "contentbasedrouter/output/xml")
                .when(header("CamelFileName").endsWith(".json"))
                    .to("file:data/padroesdeintegracao/"
                + "contentbasedrouter/output/json")
                .otherwise()
                    .to("file:data/padroesdeintegracao/"
                + "contentbasedrouter/output/others");
    }
}
