package br.com.alura.oobj.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FonteDadosTest {

  @Test
  void deveObterLeitorDeCSV() {
    LeitorFonteDados leitor = FonteDados.obtemLeitor("arquivo.csv");

    assertEquals(LeitorFonteDadosCSV.class, leitor.getClass());
  }

  @Test
  void deveObterLeitorDeXML() {
    LeitorFonteDados leitor = FonteDados.obtemLeitor("arquivo.xml");

    assertEquals(LeitorFonteDadosXML.class, leitor.getClass());
  }

  @Test
  void deveLancarExcecaoParaFormatosDesconhecidos() {
    assertThrows(IllegalArgumentException.class,
        () -> FonteDados.obtemLeitor("arquivo.xpto"));
  }
}