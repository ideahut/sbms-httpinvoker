package com.github.ideahut.sbms.httpinvoker.proxy;

import org.springframework.remoting.httpinvoker.HttpInvokerRequestExecutor;
import org.springframework.util.ClassUtils;

public class HttpInvokerProxyFactoryBean extends org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean {

	private HttpInvokerRequestExecutor httpInvokerRequestExecutor;
	
	public HttpInvokerProxyFactoryBean() {
		ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
		super.setBeanClassLoader(beanClassLoader);		
	}

	@Override
	public HttpInvokerRequestExecutor getHttpInvokerRequestExecutor() {
		if (this.httpInvokerRequestExecutor == null) {
			SimpleHttpInvokerRequestExecutor executor = new SimpleHttpInvokerRequestExecutor();
			executor.setBeanClassLoader(super.getBeanClassLoader());
			setHttpInvokerRequestExecutor(executor);
		}
		return this.httpInvokerRequestExecutor;
	}

	@Override
	public void setHttpInvokerRequestExecutor(HttpInvokerRequestExecutor httpInvokerRequestExecutor) {
		this.httpInvokerRequestExecutor = httpInvokerRequestExecutor;
		super.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor);
	}
	
}
