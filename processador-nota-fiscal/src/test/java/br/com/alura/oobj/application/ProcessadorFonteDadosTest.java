package br.com.alura.oobj.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProcessadorFonteDadosTest {

  @Mock
  private LeitorFonteDados leitor;

  @Test
  void processadorDeveObterResultadosCorretos() {
    ItemPedido itemPedido1 = criaItemPedido("2202.10.00", 1, new BigDecimal("59.99"));
    ItemPedido itemPedido2 = criaItemPedido("2202.10.00", 2, new BigDecimal("9.99"));
    List<ItemPedido> itens = Arrays.asList(itemPedido1, itemPedido2);
    Pedido pedido = new Pedido(itens);

    Mockito.when(leitor.recupera("itens")).thenReturn(pedido);

    ProcessadorFonteDados processador = new ProcessadorFonteDados(leitor);
    ResultadoProcessamento resultado = processador.processa("itens");

    assertEquals(new BigDecimal("79.97"), resultado.getTotalPedido());

    SubTotalPorClasseFiscal subTotalPorClasseFiscal = resultado.getSubTotalPorClasseFiscal();
    Iterator<SubTotalPorClasseFiscal.Item> itemIterator = subTotalPorClasseFiscal.iterator();

    assertTrue(itemIterator.hasNext());
    SubTotalPorClasseFiscal.Item item = itemIterator.next();
    assertEquals("2202.10.00", item.getClasseFiscal());
    assertEquals(new BigDecimal("79.97"), item.getSubTotal());

    assertFalse(itemIterator.hasNext());

    Mockito.verify(leitor).recupera("itens");
  }

  private ItemPedido criaItemPedido(String classeFiscal, int quantidade, BigDecimal valorUnitario) {
    ItemPedido itemPedido = new ItemPedido();
    itemPedido.setClasseFiscal(classeFiscal);
    itemPedido.setQuantidade(quantidade);
    itemPedido.setValorUnitario(valorUnitario);
    return itemPedido;
  }

}