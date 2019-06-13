package com.github.ideahut.sbms.httpinvoker.proxy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

import com.github.ideahut.sbms.client.service.ServiceProxyHeader;

public class SimpleHttpInvokerRequestExecutor extends org.springframework.remoting.httpinvoker.SimpleHttpInvokerRequestExecutor {

	@Override
	protected void prepareConnection(HttpURLConnection connection, int contentLength) throws IOException {
		Map<String, String> headers = ServiceProxyHeader.get();
		if (headers != null) {
			for (String key : headers.keySet()) {
				connection.setRequestProperty(key, headers.get(key));
			}
			ServiceProxyHeader.remove();
		}
		super.prepareConnection(connection, contentLength);
	}
	
	
	
}
