package com.mycompany.mini.curso.camel.moverarquivo;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
public class StartApp {

    public static void main(String[] args) {
        CamelContext contexto = new DefaultCamelContext();
        try {
            contexto.addRoutes(new RotaMoverArquivo());
            contexto.start();
            Thread.sleep(5000);
            contexto.stop();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
