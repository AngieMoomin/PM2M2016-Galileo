package com.hascode.bundle.information_broker_servlet.impl;

import javax.servlet.ServletException;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.osgi.util.tracker.ServiceTracker;

import com.hascode.bundle.information_broker.api.InfoCameraBroker;
import com.hascode.bundle.information_broker.api.InformationBroker;

public class Activator implements BundleActivator {
	private ServiceTracker infoSrvTracker,infoSrvTracker2;

	private ServiceTracker httpSrvTracker;

	public void start(BundleContext ctx) throws Exception {
		infoSrvTracker = new ServiceTracker(
				ctx,
				InformationBroker.class.getName(),
				null);
		infoSrvTracker2 = new ServiceTracker(
				ctx,
				InfoCameraBroker.class.getName(),
				null);

		httpSrvTracker = new ServiceTracker(ctx, HttpService.class.getName(), null) {

			public Object addingService(ServiceReference reference) {
				HttpService httpService = (HttpService) super.addingService(reference);
				try {                	                	                	
					httpService.registerServlet("/releve", new InfoBrokerServlet(infoSrvTracker), null, null);
					httpService.registerServlet("/camera", new InfoCameraBrokerServlet(infoSrvTracker2), null, null);
				} catch (ServletException e) {
				} catch (NamespaceException e) {
				}
				return httpService;
			}

			public void removedService(ServiceReference reference,
					Object service) {
				((HttpService) service).unregister("/releve");
				((HttpService) service).unregister("/camera");
				super.removedService(reference, service);
			}
		};

		infoSrvTracker.open();
		infoSrvTracker2.open();
		httpSrvTracker.open();
	}

	public void stop(BundleContext ctx) throws Exception {
		infoSrvTracker.close();  infoSrvTracker2.close();
		httpSrvTracker.close();
	}
}
