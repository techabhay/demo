package com.example.demo.test;

import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.ClientException;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;



public class IgniteTest {

	public static void main(String[] args) {

		//String url =  "dayrhetibd060.enterprisenet.org";
		//String port = "17112";
		System.out.println("ClientConfiguration Called ..");
		ClientConfiguration cfg = new ClientConfiguration().setAddresses("127.0.0.1" + ":" + "10800");


		try (IgniteClient igniteClient = Ignition.startClient(cfg)) {
			System.out.println("Connecting Ignite ");	       

			ClientCache<Integer, String> cache = igniteClient.getOrCreateCache("SAMPLE_CACHE");

			//cache.put(101, "ABHAY");
			
			System.out.println("Connection Succeed");
			String cacheVal = cache.get(101);
			System.out.println("CacheVal from Cache :: " + cacheVal);
		}
		catch (ClientException e) {
			System.err.println(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
