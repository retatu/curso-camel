package com.curso.camel.moverarquivo;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
public class StartApp {

    public static void main(String[] args) throws Exception {
        CamelContext contexto = new DefaultCamelContext();
            contexto.addRoutes(new RotaMoverArquivo());
            contexto.start();
            Thread.sleep(5000);
            contexto.stop();

    }
    
}
