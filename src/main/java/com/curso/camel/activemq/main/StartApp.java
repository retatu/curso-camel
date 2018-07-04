package com.curso.camel.activemq.main;

import com.curso.camel.activemq.rotas.RotaActivemq;
import org.apache.camel.main.Main;

public class StartApp {

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        main.addRouteBuilder(new RotaActivemq());
        main.start();
    }

}