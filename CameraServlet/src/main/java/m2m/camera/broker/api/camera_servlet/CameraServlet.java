package m2m.camera.broker.api.camera_servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.util.tracker.ServiceTracker;

public class CameraServlet extends HttpServlet {

	private static final long serialVersionUID = 1110490906466282279L;
	private ServiceTracker serviceTracker;

	public CameraServlet(ServiceTracker serviceTracker) {
		this.serviceTracker = serviceTracker;
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			ServletOutputStream out = res.getOutputStream();

			File f = new File("/home/root/workspace/Camera_Finale/releve.xml");
			FileInputStream in = new FileInputStream(f);
			byte[] buffer = new byte[1024];
			int read=0;
			while ((read=in.read(buffer))>0){
				out.write(buffer,0,read);
			}

			out.flush();
			in.close();


		} catch (IOException e) {
		}
	}
}