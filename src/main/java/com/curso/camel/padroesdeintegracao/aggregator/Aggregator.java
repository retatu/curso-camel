package com.curso.camel.padroesdeintegracao.aggregator;

import com.curso.camel.padroesdeintegracao.aggregator.aggregationmethod.SimpleAggregator;
import org.apache.camel.builder.RouteBuilder;

public class Aggregator extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("file:data/padroesdeintegracao/aggregator/csv/"
            + "input?noop=true")
                .setHeader("aggregatorId", simple("csv"))
                .log("Os headers são ${headers}")
                .convertBodyTo(String.class)
                    .aggregate(header("aggregatorId"), 
                    new SimpleAggregator()).completionSize(2)
                    .completionTimeout(2000)
        .to("file:data/padroesdeintegracao/aggregator/output/csv");
    }
}
