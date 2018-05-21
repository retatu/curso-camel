package com.curso.camel.padroesdeintegracao.filter;

import com.curso.camel.Curso;
import com.curso.camel.padroesdeintegracao.filter.bean.MeuBean;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class Filter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        DataFormat dataFormat = new BindyCsvDataFormat(Curso.class);
        
        from("file:data/padroesdeintegracao/filter/csv/input?noop=true")
            .unmarshal(dataFormat)
                .filter().method(new MeuBean(), "verificaHorasDoCurso")
                    .log("Aceita o Filter, body: ${body}")
                    .log("Verificando Headers...")
                .filter(header("CamelFileName").endsWith(".csv"))
                    .log("Aceita o Filter, headers: ${headers}")
            .marshal(dataFormat)
        .to("file:data/padroesdeintegracao/filter/csv/output");
        
    }
    
}
