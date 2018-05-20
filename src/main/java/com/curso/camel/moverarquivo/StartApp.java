package com.curso.camel.moverarquivo;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;
public class StartApp {

    public static void main(String[] args) {
//        CamelContext contexto = new DefaultCamelContext();
//        try {
//            contexto.addRoutes(new RotaMoverArquivo());
//            //contexto.start();
//            Thread.sleep(5000);
//            //contexto.stop();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
        
        Main main = new Main();
        main.addRouteBuilder(new RotaMoverArquivo());
        
        try {
            main.start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
