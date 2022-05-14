package br.com.alura.oobj.application;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class RelatorioPedidoTest {

    @Mock
    private LeitorFonteDados leitor;

    @Test
    public void TestaConversaoDeResultadoProcessamentoParaRelatorioPedido(){

        ItemPedido itemPedido1 = criaItemPedido("2202.10.00", 1, new BigDecimal("59.99"));
        ItemPedido itemPedido2 = criaItemPedido("2202.10.00", 2, new BigDecimal("9.99"));
        List<ItemPedido> itens = Arrays.asList(itemPedido1, itemPedido2);
        Pedido pedido = new Pedido(itens);

        Mockito.when(leitor.recupera("itens")).thenReturn(pedido);

        ProcessadorFonteDados processador = new ProcessadorFonteDados(leitor);
        ResultadoProcessamento resultado = processador.processa("itens");

        ClasseFiscalTotalPedido itensPorClasseFiscalList = new ClasseFiscalTotalPedido();

        List<SubTotalPorClasseFiscal.Item> listaItensSubtotalPorClasseFiscal = itensPorClasseFiscalList.retornaClasseFiscalSubTotal(resultado);

        RelatorioPedido relatorioDePedido = new RelatorioPedido(resultado,listaItensSubtotalPorClasseFiscal);

        Assertions.assertEquals(relatorioDePedido.getTotalPedido(), resultado.getTotalPedido());
        Assertions.assertEquals(relatorioDePedido.getListaItensPorClasseFiscal(), listaItensSubtotalPorClasseFiscal);

    }

    private ItemPedido criaItemPedido(String classeFiscal, int quantidade, BigDecimal valorUnitario) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setClasseFiscal(classeFiscal);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setValorUnitario(valorUnitario);
        return itemPedido;
    }

}