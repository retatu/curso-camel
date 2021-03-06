package com.curso.camel.moverarquivo;

import org.apache.camel.builder.RouteBuilder;

public class RotaMoverArquivo extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("timer:myTimer?period=10s")
            .pollEnrich("file:data/moverarquivo/input?noop=true")
        .to("file:data/moverarquivo/output");
    }
}