package com.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ShopifyUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url ="https://0f99730e50a2493463d263f6f6003622:1a27610dee9600dd8366bf76d90b5589@shopatmyspace.myshopify.com/admin/customers.json";
		try{
			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response = client.execute(get);
			System.out.println(response.getStatusLine().getStatusCode());
			BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line;
			while((line= br.readLine())!=null){
				System.out.println(line);
			}
			System.out.println(response.getEntity().getContent());
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
