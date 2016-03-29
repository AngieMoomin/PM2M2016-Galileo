package com.hascode.bundle.information_broker.impl;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.hascode.bundle.information_broker.api.*;

public class InformationBrokerImpl implements InformationBroker {


	 public String getInformation() {

		 	return "camera lancee !";
		 }
/*
	 public String afficherReleves(String cmd) {
		 System.out.println("Afficher Releves !!!");
		 String s ="Releves  : ";
		try{
			InputStream ips=new FileInputStream("/home/damont/workspace/m2m/src/Camera_Finale/releve.xml"); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){

				s+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		return s;
	
		
	}
	 */
	 public void download(String ip) {
			// TODO Auto-generated method stub
		try {
			URL url = new URL("http://"+ip+":8080/Releve");
			HttpURLConnection connexion;
			connexion= (HttpURLConnection) url.openConnection();
			connexion.connect();
			InputStream file = connexion.getInputStream();
			String copy = url.getFile().substring(1)+"_downloaded";
			FileOutputStream writeFile = new FileOutputStream("/home/ceytec/Bureau/"+copy);
			byte[] buffer = new byte[1024];
			int read=0;
			while ((read=file.read(buffer))>0){
				writeFile.write(buffer,0,read);
			}
			writeFile.flush();
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
