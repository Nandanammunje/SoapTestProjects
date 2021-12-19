package com.bharath.ws.soap.config;

import java.io.IOException;
import java.util.HashMap;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import static com.bharath.ws.soap.config.WebSvcConstants.USERNAME;
import static com.bharath.ws.soap.config.WebSvcConstants.PASSWORD;

/*public class UTPasswordCallblack implements CallbackHandler {

	private HashMap<String, String> passwordMap = new HashMap<String, String>();

	public UTPasswordCallblack() {
		passwordMap.put(USERNAME, PASSWORD);
	}

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		// TODO Auto-generated method stub
		for (Callback itr : callbacks) {
			WSPasswordCallback passwordCallBack = (WSPasswordCallback) itr;
			String password = passwordMap.get(passwordCallBack.getIdentifier());
			if (password != null) {
				System.out.print("Password is "+passwordCallBack.getPassword());
				passwordCallBack.setPassword(password);
				return;
			}

		}

	}

}
*/
