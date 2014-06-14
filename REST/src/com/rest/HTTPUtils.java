package com.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HTTPUtils {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {
	/*	UsernamePasswordCredentials cred = new UsernamePasswordCredentials("jeetu345@gmail.com", "hungry");
		
		final HttpClientContext context = HttpClientContext.create();
		context.setUserToken("0f99730e50a2493463d263f6f6003622");
		HttpGet get = new HttpGet("https://shopatmyspace.myshopify.com/admin/customers.json");
		get.addHeader("accept", "application/json");
		UserTokenHandler token = new UserTokenHandler() {
			
			@Override
			public Object getUserToken(HttpContext arg0) {
				return context.getUserToken();
			}
		};
        CloseableHttpClient client = HttpClients.custom().setDefaultCredentialsProvider(credentialsProvider);
        try {
        	CloseableHttpResponse response = client.execute(get,context);
            //Principal principal = context.getUserToken(Principal.class);
            //System.out.println(principal);
            System.out.println(response.getStatusLine().getStatusCode());
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while((line= br.readLine())!=null){
            	System.out.println(line);
            }
        } finally {
          //  response.close();
        }*/
		
		/* CredentialsProvider credsProvider = new BasicCredentialsProvider();
	        credsProvider.setCredentials(
	                new AuthScope("localhost", 443),
	                new UsernamePasswordCredentials("jeetu345@gmail.com", "hungry"));
	        CloseableHttpClient httpclient = HttpClients.custom()
	                .setDefaultCredentialsProvider(credsProvider)
	                .build();
	        try {
	            HttpGet httpget = new HttpGet("https://shopatmyspace.myshopify.com/admin/customers.json");

	            System.out.println("Executing request " + httpget.getRequestLine());
	            CloseableHttpResponse response = httpclient.execute(httpget);
	            try {
	                System.out.println("----------------------------------------");
	                System.out.println(response.getStatusLine());
	                EntityUtils.consume(response.getEntity());
	            } finally {
	                response.close();
	            }
	        } finally {
	            httpclient.close();
	        }*/
		// form based login
		
		
	}

}
