package controllers;
import java.util.List;
import org.json.*;
import models.*;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class API extends Controller {
	
	
	public Result getPlaneta(){
		
		JSONObject jso = new JSONObject();
		JSONArray jsa = new JSONArray();
		List<Planeta> planetas = Planeta.find.all();
		
		for(Planeta planeta:planetas){
			
			JSONObject jsoPlaneta = new JSONObject();
			jsoPlaneta.put("nome",planeta.nome);
			jsoPlaneta.put("sistema", planeta.sistema);
			jsoPlaneta.put("habitavel", planeta.habitavel);
			jsa.put(jsoPlaneta); 
			//Adiciona jsoPlaneta para array jsa.
		}
		
		jso.put("planetas", jsa);//Atribui a propriedade planetas vetor jsa.
		return ok (jso.toString());//Retorna a String do jso
		
	}
	public Result getEspaconave(){
		return TODO;
	}
	public Result getMissao(){
		return TODO;
	}
	public Result listaPlanetas(){
		
		List<Planeta> planetas = Planeta.find.all();
		return ok(Json.toJson(planetas));
		//return ok(views.html.tabeljquery(Json.toJson(planetas)));
	}
	
	public Result index(){
		
		return ok(views.html.tabeljquery.render());
		
	}	
}
