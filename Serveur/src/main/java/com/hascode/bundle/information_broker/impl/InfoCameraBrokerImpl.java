package com.hascode.bundle.information_broker.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.hascode.bundle.information_broker.api.InfoCameraBroker;

public class InfoCameraBrokerImpl implements InfoCameraBroker {
	public String bonjour() {
	// TODO Auto-generated method stub
	return "not implemented";
}
public void demarrerCamera(String ip) {


        //création de la connection
        URL url;
		try {
			url = new URL("http://"+ip+":8080/Camera");
			HttpURLConnection connexion;
			connexion= (HttpURLConnection) url.openConnection();
			connexion.connect();
			connexion.getResponseMessage();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    


}

}
