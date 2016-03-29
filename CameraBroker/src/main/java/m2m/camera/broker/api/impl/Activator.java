package m2m.camera.broker.api.impl;

import m2m.camera.broker.api.CameraBroker;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import java.util.Properties;

 

 
public class Activator implements BundleActivator {
	
 public void start(BundleContext ctx) throws Exception {
 ctx.registerService(CameraBroker.class.getName(),
 new CameraBrokerImpl(), new Properties());
 }
 
 public void stop(BundleContext ctx) throws Exception {
	 
 }
}
