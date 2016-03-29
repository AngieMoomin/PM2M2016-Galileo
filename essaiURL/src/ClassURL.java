import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class ClassURL {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/releve.xml");
			HttpURLConnection connexion;
			connexion= (HttpURLConnection) url.openConnection();
			
			//System.out.println(connexion.getResponseMessage());
			//connexion.connect();
			System.out.println(connexion.getURL());
			System.out.println(connexion.getContentLength());
			
			InputStream file = connexion.getInputStream();
			String copy = url.getFile().substring(1)+"_c";
			FileOutputStream writeFile = new FileOutputStream(copy);
			byte[] buffer = new byte[1024];
			int read=0;
			while ((read=file.read(buffer))>0){
				writeFile.write(buffer,0,read);
			}
			writeFile.flush();
			//System.out.println(connexion.getContentEncoding());
			file.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
