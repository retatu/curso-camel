package com.curso.camel.activemq.rotas;

import com.curso.camel.activemq.rotas.filtromethod.MinhaVerificacao;
import com.curso.camel.activemq.dominio.Aluno;
import com.curso.camel.activemq.rotas.aggregatirstrategy.SimpleAggregator;
import com.curso.camel.activemq.rotas.bean.Concatena;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.jacksonxml.JacksonXMLDataFormat;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class RotaActivemq extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        DataFormat csv = new BindyCsvDataFormat(Aluno.class);
        DataFormat xml = new JacksonXMLDataFormat(Aluno.class);
        DataFormat json = new GsonDataFormat(Aluno.class);
        
        from("activemq:queue:minhaFila")
            .filter(header("JMSXGroupID").isNotNull())
                
                .choice()
                    .when(header("JMSXGroupID").isEqualTo("csv"))
                        .to("seda:csv")
                    .when(header("JMSXGroupID").isEqualTo("xml"))
                        .to("seda:xml")
                    .when(header("JMSXGroupID").isEqualTo("json"))
                        .to("seda:json")
                    .otherwise()
                        .to("file:data/activemq/files/output/log");

        from("seda:csv")
            .unmarshal(csv)
                .filter().method(new MinhaVerificacao(), "verificaMenorDe18")
                .log("Passou pelo Filtro, body: ${body}")
            .marshal(xml)
        .to("seda:agrega");
        
        from("seda:xml")
            .unmarshal(xml)
                .filter().method(new MinhaVerificacao(), "verificaMenorDe18")
                .log("Passou pelo Filtro, body: ${body}")
            .marshal(xml)
        .to("seda:agrega");
        
        from("seda:json")
            .unmarshal(json)
                .filter().method(new MinhaVerificacao(), "verificaMenorDe18")
                .log("Passou pelo Filtro, body: ${body}")
            .marshal(xml)
        .to("seda:agrega");
        
        from("seda:agrega")
            .setHeader("agregar", simple("true"))
                .log("Os headers são ${headers}")
                .convertBodyTo(String.class)
                    .aggregate(header("agregar"), new SimpleAggregator())
                        .completionTimeout(10000)
                .log("body: ${body}")
            .bean(new Concatena(), "concatenaTag")
            .to("xslt:file:data/script/xslt/converteHTML.xslt")
        .to("file:data/activemq/files/output/html?fileName=index.html");
    }
}
