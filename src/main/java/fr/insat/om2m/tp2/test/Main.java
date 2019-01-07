package fr.insat.om2m.tp2.test;
import java.io.IOException;

import org.eclipse.om2m.commons.resource.AE;
import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.client.Response;
import fr.insat.om2m.tp2.util.RequestLoader;
import fr.insat.om2m.tp2.mapper.Mapper;
import fr.insat.om2m.tp2.mapper.MapperInterface;
import obix.Bool;
import obix.Obj;
import obix.Str;
import obix.io.ObixDecoder;
import obix.io.ObixEncoder;


public class Main {

	public static void main(String[] args) {
		
		// TODO test client
		// ...
		
		String originator = "admin:admin";
		String url = "http://127.0.0.1:8080/~/in-cse";
		Response response = null;
		Client client = new Client();
		
		
		try {
			response = client.retrieve(url, originator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(response);
		
		String type = "2";
		
		RequestLoader reaquest = new RequestLoader();
		String representation = reaquest.getRequestFromFile("create_ae.xml");
		
		try {
			response = client.create(url, representation, originator, type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(response);
		
		url = "http://127.0.0.1:8080/~/in-cse/in-name/AE_NAME";
		
		try {
			response = client.retrieve(url, originator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(response);
		
		
		url = "http://127.0.0.1:8080/~/in-cse/in-name/AE_NAME";
		representation = reaquest.getRequestFromFile("update_ae.xml");
		
		try {
			response = client.update(url, representation, originator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(response);
		
		try {
			response = client.retrieve(url, originator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(response);
		
		type = "3";
		
		representation = reaquest.getRequestFromFile("create_cnt.xml");
		
		try {
			response = client.create(url, representation, originator, type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(response);
		
		url = "http://127.0.0.1:8080/~/in-cse/in-name/AE_NAME/cnt_443028933";
		try {
			response = client.retrieve(url, originator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(response);
		
		type = "4";
		
		representation = reaquest.getRequestFromFile("create_cin.xml");
		
		try {
			response = client.create(url, representation, originator, type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(response);
		
		url = "http://127.0.0.1:8080/~/in-cse/in-name/AE_NAME/cnt_443028933/cin_116392302";
		try {
			response = client.retrieve(url, originator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//If you want to delete an object, use this code.
		/*url = "http://127.0.0.1:8080/~/in-cse/in-name/AE_NAME";
		
		try {
			response = client.delete(url, originator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(response);*/
		
		//--------------------- oBIX -----------------------------------
		
		MapperInterface mapper = new Mapper();
		
		AE ae = new AE();
		ae.setAppID("app-test");
		ae.setRequestReachability(true);
		type = "2";
		url = "http://127.0.0.1:8080/~/in-cse";
		//reaquest = new RequestLoader();
		representation = mapper.marshal(ae);
		
		try {
			response = client.create(url, representation, originator, type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(response);
		
		
		//ContentInstance cin = (ContentInstance) mapper.unmarshal(response.getRepresentation());
		
		//System.out.println(cin.getContent());		
		
		
	}
	
	

}