package com.curso.camel.conversaodedados.unmarshal;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class StartApp {

    public static void main(String[] args) throws Exception {
        CamelContext contexto = new DefaultCamelContext();
        contexto.addRoutes(new UnMarshalCSV());
        
        contexto.start();
        Thread.sleep(15000);
        contexto.stop();
    }
    
}
