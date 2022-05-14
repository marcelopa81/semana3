package br.com.alura.oobj.producer;

import br.com.alura.oobj.application.RelatorioPedido;
import br.com.alura.oobj.application.ResultadoProcessamento;

public class RelatorioService {
    private Static RELATORIO_PEDIDO_FILA = "fila.financeiro";
    private ConversorResultadoProcessamrnto resultadoProcessamentoRelatorioConverter = new ConversorResultadoProcessamrnto();
    private ConverteModeloParaXML modeloXMLConverter = new ConverteModeloParaXML();
    private Produtor produtor = new Produtor();

    public void enviarRelatorio (ResultadoProcessamento resultadoProcessamento) throws Exception {

        RelatorioPedido relatorioDePedido = resultadoProcessamentoRelatorioConverter.converte(resultadoProcessamento);

        String xmlRelatorioDePedido = modeloXMLConverter.conveteParaXML(relatorioDePedido);

        // Envia o XML para o activemq
        produtor.produzMensagem(xmlRelatorioDePedido, RELATORIO_PEDIDO_FILA);
    }
}
