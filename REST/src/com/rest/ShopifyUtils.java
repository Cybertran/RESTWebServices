package com.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

import org.apache.commons.codec.binary.*;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import sun.security.util.Password;

public class ShopifyUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShopifyService service = new ShopifyService();
		
		String url ="https://0f99730e50a2493463d263f6f6003622:1a27610dee9600dd8366bf76d90b5589@shopatmyspace.myshopify.com/admin/customers.json";
		try{
			final HttpClientContext context = HttpClientContext.create();
		
			CloseableHttpClient client = HttpClients.createDefault();
			
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response = client.execute(get,context);
			BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line;
			while((line= br.readLine())!=null){
				service.save(new JSONObject(line));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
		
		

	}


}
