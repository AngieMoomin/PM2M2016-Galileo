package com.hascode.bundle.information_broker.impl;

import com.hascode.bundle.information_broker.api.*;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import java.util.Properties;




public class Activator implements BundleActivator {
	/*
	public void start(BundleContext ctx) throws Exception {

		ctx.registerService(InformationBroker.class.getName(),
				new InformationBrokerImpl(), new Properties());
	}

	public void stop(BundleContext ctx) throws Exception {

	}
	 */
	public void start(BundleContext context) throws Exception {

		System.out.println("Start Bundle [" + context.getBundle().getSymbolicName() + "]");
		context.registerService(InformationBroker.class.getName(),
				new InformationBrokerImpl(), new Properties());
		context.registerService(InfoCameraBroker.class.getName(),
				new InfoCameraBrokerImpl(), new Properties());
		
	}
	



	public void stop(BundleContext context) throws Exception {

		System.out.println("Stop Bundle [" + context.getBundle().getSymbolicName() + "]");
		
	}

}
