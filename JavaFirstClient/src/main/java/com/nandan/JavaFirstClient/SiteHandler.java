package com.nandan.JavaFirstClient;

import static com.nandan.JavaFirstClient.Constants.ClientConstants.SITEHANDLERLOCALNAME;
import static com.nandan.JavaFirstClient.Constants.ClientConstants.SITENAME;
import static com.nandan.JavaFirstClient.Constants.ClientConstants.NAMESPACE;
import static com.nandan.JavaFirstClient.Constants.ClientConstants.NAMESPACEPREFIX;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SiteHandler implements SOAPHandler<SOAPMessageContext> {

	public boolean handleMessage(SOAPMessageContext context) {

		boolean messageType = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (messageType) {
			try {
				SOAPMessage message = context.getMessage();
				SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
				SOAPHeader soapHeader = envelope.addHeader();
				SOAPElement siteName = soapHeader.addChildElement(SITEHANDLERLOCALNAME, NAMESPACEPREFIX, NAMESPACE);
				siteName.addTextNode(SITENAME);
				message.saveChanges();
				message.writeTo(System.out);

			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// TODO Auto-generated method stub
		return true;
	}

	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
