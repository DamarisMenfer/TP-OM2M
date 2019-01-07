package fr.insat.om2m.tp2.test;

import org.eclipse.om2m.commons.resource.AE;

import fr.insat.om2m.tp2.mapper.Mapper;
import fr.insat.om2m.tp2.mapper.MapperInterface;
import fr.insat.om2m.tp2.util.RequestLoader;
import obix.Bool;
import obix.Obj;
import obix.Str;
import obix.io.ObixDecoder;
import obix.io.ObixEncoder;

public class MapperTest {

	public static void main(String[] args) {
		MapperInterface mapper = new Mapper();

		// example to test marshal operation
		AE ae = new AE();
		ae.setRequestReachability(false); 
		System.out.println(mapper.marshal(ae));
		
		// TODO test unmarshal
		RequestLoader reaquest = new RequestLoader();
		String representation = reaquest.getRequestFromFile("create_ae.xml");
		System.out.println(mapper.unmarshal(representation));
		
		Bool value = new Bool(true);
		Str location = new Str("home");
		Obj object = new Obj();
		object.add("value", value);
		object.add("location", location);
		
		String result = ObixEncoder.toString(object);
		System.out.println(result);
		Obj obj = ObixDecoder.fromString(result);
	}
	
}
