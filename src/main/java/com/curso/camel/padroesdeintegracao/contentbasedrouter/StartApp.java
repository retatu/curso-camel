package com.curso.camel.padroesdeintegracao.contentbasedrouter;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class StartApp {

    public static void main(String[] args) throws Exception {
        CamelContext contexto = new DefaultCamelContext();
        contexto.addRoutes(new ContentBasedRouter());
        
        contexto.start();
        Thread.sleep(15000);
        contexto.stop();
    }
    
}
