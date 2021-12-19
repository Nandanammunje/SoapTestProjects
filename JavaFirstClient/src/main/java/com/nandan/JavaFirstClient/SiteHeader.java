package com.nandan.JavaFirstClient;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

public class SiteHeader implements HandlerResolver {

	public List<Handler> getHandlerChain(PortInfo portInfo) {
		// TODO Auto-generated method stub
		ArrayList<Handler> handlerChain = new ArrayList();
		SiteHandler siteHandler = new SiteHandler();
		handlerChain.add(siteHandler);

		return handlerChain;
	}

}
