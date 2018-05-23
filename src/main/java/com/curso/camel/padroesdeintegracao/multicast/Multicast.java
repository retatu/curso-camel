package com.curso.camel.padroesdeintegracao.multicast;

import com.curso.camel.padroesdeintegracao.multicast.bean.MeuBean;
import org.apache.camel.builder.RouteBuilder;

public class Multicast extends RouteBuilder{
    @Override
    public void configure() throws Exception {       
        from("file:data/padroesdeintegracao/multicast/"
            + "input?noop=true")
            .multicast()//.parallelProcessing()
                .to("seda:proxima", "seda:analisadora");        
        from("seda:proxima")
            .log("Fazendo alguma coisa...")
                .bean(new MeuBean(), "delay")
                    .to("file:data/padroesdeintegracao/"
                        + "multicast/output?noop=true");        
        from("seda:analisadora")
            .log("Analisando...")
                .bean(new MeuBean(), "delay")
                    .to("file:data/padroesdeintegracao/"
                        + "multicast/output/analisada?noop=true");
        
    }   
}
