package com.rest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.utils.URIBuilder;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
public class ZohoUtils extends Thread {
	private static String serverUrl ="https://crm.zoho.com/crm/private/"; 
    private static String authtoken = "fde7ef1e59431f837d73788056f18329";

	/**
	 * @param args
	 * @throws JSONException 
	 */
	public static void main(String[] args) throws JSONException {
          
      /*  Thread t = new Thread();
        t.start();*/
		for(int i=1;i<10000;){
			JSONArray data = getData(i);
			String res = data.getString(0);
			JSONObject o = new JSONObject(res);
			//System.out.println(o);
			JSONObject o1 = new JSONObject(o.get("response").toString());
			System.out.println(o1.toString());
			JSONObject obj = new JSONObject(o1.toString());
			String [] names = obj.getNames(obj);
			String rs = names[0];
			if(rs.equalsIgnoreCase("result")){
				System.out.println(obj.toString());
			    i=i+200;
			}
			else
				break;
		}
        	//Map<String,String> map = new HashMap<String,String>();
        	//ObjectMapper mapper = new ObjectMapper();
        
      
          
	}
	
	public static JSONArray getData(int fromIndex){
		   StringBuilder sb = new StringBuilder(serverUrl).append("json").append("/Leads/").append("getRecords");
		   JSONArray data = new JSONArray();
           try{
        	   URIBuilder uri = new URIBuilder(sb.toString());
        	   uri.setQuery("authtoken");
        	   uri.setParameter("authtoken", authtoken);
        	   uri.setParameter("scope", "crmapi");
        	   uri.addParameter("fromIndex",""+fromIndex);
        	   uri.addParameter("toIndex", ""+200);
        	   uri.build();
        	   URL url = new URL(uri.toString());
        	   URLConnection con = url.openConnection();
        	   con.connect();
        	   BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        	   String line;
        	   while((line = br.readLine())!=null){
        		   data.put(line);
        	   }
           }catch(Exception e){
        	   e.printStackTrace();
           }
           return data;
		
	}
	
	@Override
	public void run(){
		System.out.println("run is called");
		for(int i=1;i<10000;){
			JSONArray data = getData(i);
			System.out.println(data);
			i=i+200;
		}
	}
	


}
