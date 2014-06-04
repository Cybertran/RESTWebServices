package com.rest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.client.utils.URIBuilder;
public class ZohoUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
          String serverUrl ="https://crm.zoho.com/crm/private/"; 
	      String authtoken = "d406daed81b0e04755e5a8c1a2106fda";
         // String targetURL = "https://crm.zoho.com/crm/private/xml/Leads/getRecords"; 
           String paramname = "content";
           StringBuilder sb = new StringBuilder(serverUrl).append("json").append("/Contacts/").append("getMyRecords");
           try{
        	   URIBuilder uri = new URIBuilder(sb.toString());
        	   uri.setQuery("authtoken");
        	   uri.setParameter("authtoken", authtoken);
        	   uri.setParameter("scope", "crmapi");
        	   uri.build();
        	   URL url = new URL(uri.toString());
        	   URLConnection con = url.openConnection();
        	   con.connect();
        	BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        	String in;
        	while((in = br.readLine())!=null){
        		System.out.println(in);
        	}
        	
        	   
        	System.out.println(uri);
           }catch(Exception e){
        	   e.printStackTrace();
           }
	}

}
