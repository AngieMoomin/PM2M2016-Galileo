package com.hascode.bundle.information_broker_servlet.impl;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.util.tracker.ServiceTracker;

import com.hascode.bundle.information_broker.api.InfoCameraBroker;

public class InfoCameraBrokerServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServiceTracker serviceTracker;

	public InfoCameraBrokerServlet(ServiceTracker serviceTracker) {
		this.serviceTracker = serviceTracker;
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			ServletOutputStream out = res.getOutputStream();
			out.println("<html>");
			out.print("<head><title><center>M2M-CAMERA</center></title></head>");
			out.print("<body>");
			out.print("<h1>Bienvenue sur Camera Servlet !</h1>");
			out.print("<h3>Bienvenue sur le serveur !</h3>");


			InfoCameraBroker broker = (InfoCameraBroker) serviceTracker.getService();
			if (broker != null) {
				out.println("demarrage de la camera en cours ...");
				broker.demarrerCamera("192.168.1.49");
			}
			out.println("</body></html>");

		} catch (IOException e) {
		}
	}
}
