package br.com.alura.oobj.application;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class RelatorioPedido{

    private UUID id = UUID.randomUUID();

    private BigDecimal totalPedido;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    private List<ClasseFiscalTotalPedido> listaItens = new ArrayList<>();

    public RelatorioPedido(UUID id, BigDecimal totalPedido, LocalDateTime dataCriacao,
                           List<ClasseFiscalTotalPedido> listaIntens) {
        this.id = id;
        this.totalPedido = totalPedido;
        this.dataCriacao = dataCriacao;
        this.listaItens = listaItens;
    }

}
