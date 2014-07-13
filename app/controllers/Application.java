package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import play.libs.F;
import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public static Promise<Result> index() {
        
    	System.out.println("index...");
    	
    	String urlName ="http://localhost:9000/mark/name";
    	String urlHobbie ="http://localhost:9000/mark/hobbie";
    	
    	Promise<WSResponse> promiseName = WS.url(urlName).get();    	
    	Promise<WSResponse> promiseHobbie = WS.url(urlHobbie).get();   	
    	Promise<Result> nameResult = promiseName.map(response -> ok("The calculation result is: " + response.getBody())); 
    	Promise<Result> hobbieResult = promiseHobbie.map(response -> ok("The hobbie is: " + response.getBody()));
    	
    	
    	System.out.println("end index...");
    	return hobbieResult;
    }
    
    public static Result lambda() {
    	
    	List<String> names = new ArrayList<String>();
    	names.add("Marcos");
    	names.add("Juan");
    	names.add("Ariel");
    	
    	
    	Stream<String> filtered = names.stream().filter(n -> n.length() > 4);
    	
    	filtered.forEach( name -> System.out.println(name));
    	
    	
    	return ok();
    }
}
