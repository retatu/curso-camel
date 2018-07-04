package com.curso.camel.activemq.rotas.filtromethod;

import com.curso.camel.activemq.dominio.Aluno;
import org.apache.camel.Exchange;

public class MinhaVerificacao {

    public boolean verificaMenorDe18(Exchange exchange) {
        Aluno curso = exchange.getIn().getBody(Aluno.class);

        return curso.getIdade() >= 18;
    }
}
