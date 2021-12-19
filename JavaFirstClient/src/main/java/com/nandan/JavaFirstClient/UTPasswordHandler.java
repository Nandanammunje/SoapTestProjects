package com.nandan.JavaFirstClient;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import static com.nandan.JavaFirstClient.Constants.ClientConstants.USERNAME;
import static com.nandan.JavaFirstClient.Constants.ClientConstants.PASSWORD;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordHandler implements CallbackHandler {

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		// TODO Auto-generated method stub
		for (Callback itr : callbacks) {
			WSPasswordCallback wpc = (WSPasswordCallback) itr;
			if (USERNAME.equals(wpc.getIdentifier())) {
				wpc.setPassword(PASSWORD);
				return;
			}
		}

	}

}
