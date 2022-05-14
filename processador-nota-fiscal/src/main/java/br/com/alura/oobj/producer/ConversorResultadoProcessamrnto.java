package br.com.alura.oobj.producer;


import br.com.alura.oobj.application.ClasseFiscalTotalPedido;
import br.com.alura.oobj.application.RelatorioPedido;
import br.com.alura.oobj.application.ResultadoProcessamento;
import br.com.alura.oobj.application.SubTotalPorClasseFiscal;

import java.util.List;


public class ConversorResultadoProcessamrnto {
    private ClasseFiscalTotalPedido itensClasseFiscalTotalPedido = new ClasseFiscalTotalPedido();

    public RelatorioPedido converte (ResultadoProcessamento resultadoProcessamento){
        List<SubTotalPorClasseFiscal.Item> listaIternsClasseFiscalSubTotal = itensClasseFiscalTotalPedido.retornaClasseFiscalSubTotal(
                resultadoProcessamento);
        RelatorioPedido relatorioPedido = new RelatorioPedido(resultadoProcessamento, listaIternsClasseFiscalSubTotal);
        return relatorioPedido;
    }

}

