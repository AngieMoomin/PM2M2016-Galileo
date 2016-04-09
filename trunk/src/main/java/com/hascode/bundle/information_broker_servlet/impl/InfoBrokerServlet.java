package com.hascode.bundle.information_broker_servlet.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.util.tracker.ServiceTracker;
import com.hascode.bundle.information_broker.api.InformationBroker;

public class InfoBrokerServlet extends HttpServlet {

	private static final long serialVersionUID = 1110490906466282279L;
	private ServiceTracker serviceTracker;

	public InfoBrokerServlet(ServiceTracker serviceTracker) {
		this.serviceTracker = serviceTracker;
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			ServletOutputStream out = res.getOutputStream();
			out.println("<html>");
			out.print("<head><title><center>M2M-circulation</center></title></head>");
			out.print("<body>");
			out.print("<h1>Bienvenue sur le serveur !</h1>");



			InformationBroker broker = (InformationBroker) serviceTracker.getService();
			if (broker != null) {
				out.print("Télechargement du relevé ...");
				broker.download("192.168.1.101");
			}
			out.println("</body></html>");

		} catch (IOException e) {
		}
	}
}