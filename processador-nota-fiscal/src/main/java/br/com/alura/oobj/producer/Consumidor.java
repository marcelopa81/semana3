package br.com.alura.oobj.producer;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Scanner;


public class Consumidor {

    public static void main(String[] args) throws Exception {

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
        MessageConsumer consumer = session.createConsumer(fila);
        /*Recebendo a mensagem com a interface setMessageListenere e a implementação de uma
        classe anônima que implementa a interface, que trata a mensagem. O new MessageListener() definirá um
        método que recebe a mensagem*/
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                //Fazendo um cast na mensdgem recebida com a sub interface TextMessage
                TextMessage textMessage = (TextMessage)message;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        new Scanner(System.in).nextLine();

        session.close();
        connection.close();
        context.close(); //fechando a conexão com o registro

    }

}
