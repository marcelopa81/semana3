package br.com.alura.oobj.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoTest {

  private ItemPedido itemPedido;

  @BeforeEach
  public void setUp() {
    itemPedido = new ItemPedido();
    itemPedido.setValorUnitario(new BigDecimal("9.99"));
  }

  @Test
  void subtotalDoItemPedidoDeveSerIgualAoPrecoQuandoForUmaUnidade() {
    itemPedido.setQuantidade(1);

    BigDecimal subtotal = itemPedido.getSubtotal();

    assertEquals(new BigDecimal("9.99"), subtotal);
  }

  @Test
  void subtotalDoItemPedidoDeveConsiderarQuantidade() {
    itemPedido.setQuantidade(2);

    BigDecimal subtotal = itemPedido.getSubtotal();

    assertEquals(new BigDecimal("19.98"), subtotal);
  }

}