package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Espaconave;
import models.Planeta;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;

public class Planetas extends Controller{

	
	private final Form<Planeta> formPlaneta = Form.form(Planeta.class);
	
	
	List<Planeta> planetas = Planeta.find.all();

	public Result novo()
	{
		return ok(views.html.aplicacao.planeta.render(formPlaneta));
	}
	
	public Result lista()
	{
		List<Planeta> planetas = Planeta.find.all();
		return ok(views.html.listaplanetas.render(planetas));
	}
	
	public Result salvar()
	{
		
		Form<Planeta> formEnviado = formPlaneta.bindFromRequest();

		if(formEnviado.hasErrors()){
		 flash("error", "Por favor corrija o formulário abaixo");
		}

		Planeta planeta = formEnviado.get();
		planeta.save();
		return ok(views.html.aplicacao.planeta.render(formPlaneta));
	}
	
	public Result update()
	{
		
		Form<Planeta> formEnviado = formPlaneta.bindFromRequest();

		if(formEnviado.hasErrors()){
		 flash("error", "Por favor corrija o formulário abaixo");
		}

		Planeta planeta = formEnviado.get();
		planeta.update();
		
		List<Planeta> planetas = Planeta.find.all();
		return ok(views.html.listaplanetas.render(planetas));
	}
	
	
	public Result remover(Long id)
	{
		
		Planeta planeta = Planeta.find.byId(id);
		planeta.delete();
		return redirect(routes.Planetas.lista());

	}
	
	public Result exibir_editar(Long id)
	{
		
		Planeta planeta = Planeta.find.byId(id);
		Form<Planeta> formPlanetaPreenchido = formPlaneta.fill(planeta);
		return ok(views.html.aplicacao.planetaUpdate.render(formPlanetaPreenchido,planeta.getId()));

	}

	
	
}
