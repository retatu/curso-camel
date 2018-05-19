package com.mycompany.mini.curso.camel.moverarquivo;

import org.apache.camel.builder.RouteBuilder;

public class RotaMoverArquivo extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("file:data/moverarquivo/input?noop=true")
                .to("log:?showBody=true")
                .to("file:data/moverarquivo/output");
    }
}