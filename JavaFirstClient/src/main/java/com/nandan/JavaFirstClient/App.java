package com.nandan.JavaFirstClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.EndpointImpl;

import com.nandan.JavaFirstClient.PaymentService.PaymentProcessor;
import com.nandan.JavaFirstClient.PaymentService.PaymentProcessorImplService;
import com.nandan.JavaFirstClient.PaymentService.PaymentProcessorRequest;
import com.nandan.JavaFirstClient.PaymentService.PaymentProcessorResponse;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			PaymentProcessorImplService paymentClientSvc = new PaymentProcessorImplService(
					new URL("file:///home/devnandan/WsdlSource/JavaFirstService/service/paymentprocess.wsdl"));
			 SiteHeader siteHeader=new SiteHeader();
			paymentClientSvc.setHandlerResolver(siteHeader);
			PaymentProcessor paymentProcessorImplPort = paymentClientSvc.getPaymentProcessorImplPort();
		   
			
			

			PaymentProcessorResponse processPayment = paymentProcessorImplPort
					.processPayment(new PaymentProcessorRequest());
			System.out.println("Hello World!" + processPayment.isResult());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
