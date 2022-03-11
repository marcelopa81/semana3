package br.com.alura.oobj.application;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

  @Test
  void totalDoPedidoDeveConsiderarMultiplosItens() {
    ItemPedido itemPedido1 = criaItemPedido(1, new BigDecimal("59.99"));
    ItemPedido itemPedido2 = criaItemPedido(2, new BigDecimal("9.99"));
    List<ItemPedido> itens = Arrays.asList(itemPedido1, itemPedido2);

    Pedido pedido = new Pedido(itens);

    BigDecimal total = pedido.getTotal();

    assertEquals(new BigDecimal("79.97"), total);
  }

  @Test
  void totalDoPedidoDeveConsiderarUmUnicoItem() {
    ItemPedido itemPedido1 = criaItemPedido(1, new BigDecimal("59.99"));
    List<ItemPedido> itens = Arrays.asList(itemPedido1);

    Pedido pedido = new Pedido(itens);

    BigDecimal total = pedido.getTotal();

    assertEquals(new BigDecimal("59.99"), total);
  }

  @Test
  void totalDoPedidoDeveConsiderarQuandoNaoHouverNenhumItem() {
    List<ItemPedido> itens = new ArrayList<>();
    Pedido pedido = new Pedido(itens);

    BigDecimal total = pedido.getTotal();

    assertEquals(BigDecimal.ZERO, total);
  }

  @Test
  void totalDoPedidoDeveLancarExcecaoQuandoItensForemNulos() {
    Pedido pedido = new Pedido();
    pedido.setItens(null);

    assertThrows(IllegalStateException.class, pedido::getTotal);
  }

  private ItemPedido criaItemPedido(int quantidade, BigDecimal valorUnitario) {
    ItemPedido itemPedido = new ItemPedido();
    itemPedido.setQuantidade(quantidade);
    itemPedido.setValorUnitario(valorUnitario);
    return itemPedido;
  }

}