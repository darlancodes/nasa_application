package controllers;

import java.util.ArrayList;
import java.util.List;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model.Finder;

import models.Planeta;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public Result principal() {
        return ok(views.html.principal.render());
    }
    
    //public Result teste() {
    	    	
    	//return ok(views.html.home.render(new ArrayList()));
    //}
    
    //public Result names_plan_espaco() {
    	
    	//return ok(views.html.missoes.render(new ArrayList(),new ArrayList()));
    //}

}
