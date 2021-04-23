/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activemqq;

import com.mycompany.activemq.vistas.VistaPrincipal;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.swing.JFrame;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author Usuario
 */
public class MessageReceiver implements ExceptionListener{
    
    /*
    
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    
    private static String queueName = "MESSAGE_QUEUE";
    
    public void producessConsumer(){
        String clientID="bryam";
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
            
            connection.setExceptionListener(this);
             Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);
            
            MessageConsumer consumer = session.createConsumer(destination);
            
            consumer.setMessageListener(listener);
            connection.start();
            
        }catch(Exception e){
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
    
    MessageListener listener = new MessageListener(){
      
        public void onMessage(Message msg) {
            if(msg instanceof TextMessage){
                TextMessage textMessage = (TextMessage) msg;
                String text = null;
                try{
                    VistaPrincipal.jTextField1.setText(text);
                    text = textMessage.getText();
                }catch (JMSException e){
                    e.printStackTrace();
                }
                
                System.out.println("Recibido: " + text);
            }else{
                System.out.println("Recibido: " + msg);
                VistaPrincipal.jTextField1.setText(msg.toString());
            }
        }
        
    };
*/
    
    public static void main(String[] args) throws JMSException
	{
            
            VistaPrincipal vista = new VistaPrincipal();
            vista.setVisible(true);
            //create JFrame Instance
         
        }

    @Override
    public void onException(JMSException jmse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
