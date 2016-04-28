package controllers;

import java.util.List;

import models.Espaconave;
import models.Planeta;
import play.data.Form;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.http.HttpErrorHandler;

public class Espaconaves extends Controller {

	private final Form<Espaconave> formEspaconave = Form.form(Espaconave.class);
	
	public Result novo()
	{
		return ok(views.html.aplicacao.espaconaves.render(formEspaconave));
	}
	
	public Result lista()
	{
		List<Espaconave> espaconaves = Espaconave.find.all();
		return ok(views.html.listaespaconaves.render(espaconaves));
	}
	
	public Result salvar()
	{
		
		Form<Espaconave> formEnviado = formEspaconave.bindFromRequest();

		if(formEnviado.hasErrors()){
		 flash("error", "Por favor corrija o formulário abaixo");
		}

		Espaconave espaconave = formEnviado.get();
		espaconave.save();
		flash("error", "Planeta Não encontrado");
		return ok(views.html.aplicacao.espaconaves.render(formEspaconave));
	}
	
	public Result remover(Long id)
	{
		
		Espaconave espaconave = Espaconave.find.byId(id);
		espaconave.delete();
		return redirect(routes.Espaconaves.lista());
		
	}
	
	public Result exibir_editar(Long id)
	{
		
		Espaconave espaconave = Espaconave.find.byId(id);
		Form<Espaconave> formEspaconavePreenchido = formEspaconave.fill(espaconave);
		return ok(views.html.aplicacao.espaconaveUpdate.render(formEspaconavePreenchido,espaconave.getId()));

	}
	
	public Result update()
	{
		
		Form<Espaconave> formEnviado = formEspaconave.bindFromRequest();

		if(formEnviado.hasErrors()){
		 flash("error", "Por favor corrija o formulário abaixo");
		}

		Espaconave espaconave = formEnviado.get();
		espaconave.update();
		
		List<Espaconave> espaconaves = Espaconave.find.all();
		return ok(views.html.listaespaconaves.render(espaconaves));
	}
	
	
	
	
}
