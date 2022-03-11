package br.com.alura.oobj.application;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SubTotalPorClasseFiscalTest {

  @Test
  void subTotaisDevemSerClassificadosPorClasseFiscal() {
    SubTotalPorClasseFiscal subTotalPorClasseFiscal = new SubTotalPorClasseFiscal();

    ItemPedido itemPedido1 = criaItemPedido("2202.90.90", 1, new BigDecimal("59.99"));
    subTotalPorClasseFiscal.adicionaItemPedido(itemPedido1);

    ItemPedido itemPedido2 = criaItemPedido("2202.90.90", 2, new BigDecimal("9.99"));
    subTotalPorClasseFiscal.adicionaItemPedido(itemPedido2);

    ItemPedido itemPedido3 = criaItemPedido("2100.90.90", 1, new BigDecimal("19.99"));
    subTotalPorClasseFiscal.adicionaItemPedido(itemPedido3);

    Iterator<SubTotalPorClasseFiscal.Item> itemIterator = subTotalPorClasseFiscal.iterator();

    assertTrue(itemIterator.hasNext());
    SubTotalPorClasseFiscal.Item item1 = itemIterator.next();
    assertEquals("2100.90.90", item1.getClasseFiscal());
    assertEquals(new BigDecimal("19.99"), item1.getSubTotal());

    assertTrue(itemIterator.hasNext());
    SubTotalPorClasseFiscal.Item item2 = itemIterator.next();
    assertEquals("2202.90.90", item2.getClasseFiscal());
    assertEquals(new BigDecimal("79.97"), item2.getSubTotal());

    assertFalse(itemIterator.hasNext());
  }

  private ItemPedido criaItemPedido(String classeFiscal, int quantidade, BigDecimal valorUnitario) {
    ItemPedido itemPedido = new ItemPedido();
    itemPedido.setClasseFiscal(classeFiscal);
    itemPedido.setQuantidade(quantidade);
    itemPedido.setValorUnitario(valorUnitario);
    return itemPedido;
  }

}