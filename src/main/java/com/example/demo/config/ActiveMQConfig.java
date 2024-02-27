package com.example.demo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import com.example.demo.Utils.EncryptUtils;

@Configuration
@EnableJms
public class ActiveMQConfig {

    @Value("${spring.activemq.broker-url}")
    private String url;

	@Value("${spring.activemq.user}")
    private String user;
    
	@Value("${spring.activemq.password}")
    private String password;
	
	//HICE ESTE BEAN EXCLUSIVAMENTE PARA PODER ENCRIPTAR LAS CLAVES EN EL APLICATION.PROPERTIES (ANTES ESTABA SIN ESTE BEAN E IGUAL FUNCIONABA PERFECT PERO LE AGREGAMOS SEGURIDAD)
	
    /* Hay que agregar esto al archivo activemq.xml ya que por defecto viene sin usuarios activos (solo el admin/admin de el admin web)
     <plugins>
	    <simpleAuthenticationPlugin>
	        <users>
	            <authenticationUser username="admin" password="admin" groups="admins,users"/>
	        </users>
	    </simpleAuthenticationPlugin>
	</plugins>
	*/
	
	@Bean
    ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(url);
        connectionFactory.setUserName(EncryptUtils.desencriptar(user));
        connectionFactory.setPassword(EncryptUtils.desencriptar(password));
        return connectionFactory;
    }

    @SuppressWarnings("null")
	@Bean
    JmsTemplate jmsTemplate(){
        return new JmsTemplate(connectionFactory());
    }

}
