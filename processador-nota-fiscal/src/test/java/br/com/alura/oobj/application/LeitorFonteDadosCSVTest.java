package br.com.alura.oobj.application;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeitorFonteDadosCSVTest {

  @Test
  void deveRecuperarPedidoDoCSV() {
    LeitorFonteDadosCSV leitor = new LeitorFonteDadosCSV();

    String nomeArquivo = LeitorFonteDadosCSVTest.class.getResource("/itens-pedido-teste.csv").getFile();

    Pedido pedido = leitor.recupera(nomeArquivo);
    assertNotNull(pedido);

    List<ItemPedido> itens = pedido.getItens();
    assertNotNull(itens);
    assertEquals(2, itens.size());

    ItemPedido itemPedido1 = itens.get(0);
    assertNotNull(itemPedido1);
    assertEquals(4, itemPedido1.getCodigo());
    assertEquals("Gyoza Bovino", itemPedido1.getDescricao());
    assertEquals(3, itemPedido1.getQuantidade());
    assertEquals(new BigDecimal("23.5"), itemPedido1.getValorUnitario());
    assertEquals("2106.90.90", itemPedido1.getClasseFiscal());

    ItemPedido itemPedido2 = itens.get(1);
    assertNotNull(itemPedido2);
    assertEquals(9, itemPedido2.getCodigo());
    assertEquals("Coca-Cola Lata 310 ML", itemPedido2.getDescricao());
    assertEquals(1, itemPedido2.getQuantidade());
    assertEquals(new BigDecimal("5.9"), itemPedido2.getValorUnitario());
    assertEquals("2202.10.00", itemPedido2.getClasseFiscal());
  }

}