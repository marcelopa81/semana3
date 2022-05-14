package br.com.alura.oobj.application;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RelatorioPedido{

    private UUID id = UUID.randomUUID();

    private BigDecimal totalPedido;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    private List<SubTotalPorClasseFiscal.Item> listaItensPorClasseFiscal = new ArrayList<>();


    public RelatorioPedido(ResultadoProcessamento resultadoProcessamento, List<SubTotalPorClasseFiscal.Item>
                           listaItens) {
        this.id = UUID.randomUUID();
        this.totalPedido = resultadoProcessamento.getTotalPedido();
        this.dataCriacao = LocalDateTime.now();
        this.listaItensPorClasseFiscal = listaItens;
    }

  public List<SubTotalPorClasseFiscal.Item> getListaItensPorClasseFiscal(){
        return listaItensPorClasseFiscal;
  }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }
}
