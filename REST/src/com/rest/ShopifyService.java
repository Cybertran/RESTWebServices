package com.rest;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class ShopifyService {
	ShopifyAgileMapper mapper = new ShopifyAgileMapper();
	
	public void save(JSONObject customers){
		try{
		JSONArray arr = customers.getJSONArray("customers");
		for(int i=0;i<arr.length();i++){
			JSONObject customer = new JSONObject(arr.get(i).toString());
			System.out.println(customer.toString());
			System.out.println(customer.get("first_name"));
			//mapper.saveCustomers(customer);
			
			
		}
		
		}catch (Exception e) {
            e.printStackTrace();
		}
	}
	

}
