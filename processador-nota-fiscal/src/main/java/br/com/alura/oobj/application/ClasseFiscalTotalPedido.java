package br.com.alura.oobj.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClasseFiscalTotalPedido {
    private String classeFiscal;
    private BigDecimal totalPedido;

    public List<SubTotalPorClasseFiscal.Item> retornaClasseFiscalSubTotal(ResultadoProcessamento
                                                                                  resultadoProcessamento) {
        List<SubTotalPorClasseFiscal.Item> listaItens = new ArrayList<>();
        for (SubTotalPorClasseFiscal.Item item: resultadoProcessamento.getSubTotalPorClasseFiscal()) {
            this.classeFiscal = item.getClasseFiscal();
            this.totalPedido = item.getSubTotal();
            listaItens.add(item);
        }
      return listaItens;
    }


    public String getClasseFiscal() {
        return classeFiscal;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

}
