package br.com.alura.oobj.producer;

import br.com.alura.oobj.application.RelatorioPedido;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConverteModeloParaXML {
    public String conveteParaXML(RelatorioPedido relatorioPedido){
        try{
            ObjectMapper xmlMapper = new ObjectMapper();
            return xmlMapper.writeValueAsString(relatorioPedido);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
