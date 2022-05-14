package br.com.alura.oobj.producer;

import javax.jms.*;
import javax.naming.InitialContext;


public class Produtor {

    public void produzMensagem(String mensagem, String nomeDoDestino) throws Exception {

        /*context é instanciado para acessar o arquivo jndi, que possui o arquivo de configuração jndi.properties
        Ao ser criador InitialContext, o context procura o arquivo jndi.properties */
        InitialContext context = new InitialContext();

        //Criando a connectionFactory que será inicializada pelo MOM.Esse name está na documentação do MOM
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

        //Estabelecer uma conexão javax.jms.Connection - Criando a conexão
        Connection connection = factory.createConnection();

        //Inicializado a conexão explicitamente
        connection.start();

        /*Criando o objeto session, que cria o consumidor. A session tem a responsabilidade de trabalhar
        com a transação e confirmação do recebimento da mensagem - abstrai de consumer e connection */
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //Criando o consumidor - recebe mensagens
        Destination fila = (Destination) context.lookup("financeiro");

        //Criando um produtor que recebe a fila
        MessageProducer messageProducer = session.createProducer(fila);

        //Enviando a mensagem
        Message message = session.createTextMessage(mensagem);
       // Message message = session.createTextMessage(mensagem);
        messageProducer.send(message);

        session.close();
        connection.close();
        context.close(); //fechando a conexão com o registro

    }

}
