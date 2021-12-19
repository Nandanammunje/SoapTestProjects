package com.bharath.ws.soap.config;

import java.util.ArrayList;

import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bharath.ws.soap.PaymentProcessorImpl;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint setEndPoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new PaymentProcessorImpl());
		endpoint.publish("/paymentProcess");
		SOAPBinding binding=(SOAPBinding) endpoint.getBinding();
		ArrayList<Handler> handlerChain=new ArrayList<>();
		handlerChain.add(new SiteHandler());
		binding.setHandlerChain(handlerChain);
		

		/*HashMap<String, Object> interceptMap = new HashMap<String, Object>();
		interceptMap.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
		interceptMap.put(ConfigurationConstants.PASSWORD_TYPE,WSConstants.PW_TEXT);
		interceptMap.put(ConfigurationConstants.PW_CALLBACK_CLASS,UTPasswordCallblack.class.getName());
		WSS4JInInterceptor wsIn = new WSS4JInInterceptor(interceptMap);
		endpoint.getInInterceptors().add(wsIn);*/

		return endpoint;

	}

}
