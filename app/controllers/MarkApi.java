package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class MarkApi extends Controller {

	
	
    public static Result slowName() {
    	
    	System.out.println("waiting for Name...");
    	waitALittle(2000);
        return ok("Marcos.");
    }

    public static Result slowHobbie() {
    	System.out.println("waiting for Hobbie...");
    	waitALittle(8000);
        return ok("La fotografia");
    }
	
    private static void waitALittle(int milis) {
    	try {
    		Thread.sleep(milis);
    	}
    	catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    }
}

