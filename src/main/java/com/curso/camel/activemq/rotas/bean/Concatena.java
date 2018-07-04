package com.curso.camel.activemq.rotas.bean;

public class Concatena {
    
    public String concatenaTag(String body){
        return "<ALUNOS>".concat(body).concat("</ALUNOS>");
    }
}
