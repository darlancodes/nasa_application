package controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.Missao;
import models.Planeta;
import models.Espaconave;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Missoes extends Controller{

	
		private final Form<Missao> formMissao = Form.form(Missao.class);
		
		
		public Result relatorio()
		{
			List<Espaconave> espaconaves = Espaconave.find.all();
			List<Planeta> planetas = Planeta.find.all();
			List<Missao> missoes = Missao.find.all();
			return ok(views.html.aplicacao.relatorio.render(formMissao,missoes,planetas,espaconaves));
		}
		
		public Result lista()
		{
			List<Espaconave> espaconaves = Espaconave.find.all();
			List<Planeta> planetas = Planeta.find.all();
			List<Missao> missoes = Missao.find.all();
			return ok(views.html.listamissoes.render(formMissao,missoes,planetas,espaconaves));
		}
			
		
		public Result remover(Long id)
		{
						
			Missao missao = Missao.find.byId(id);
			missao.delete();
			return redirect(routes.Missoes.lista());

		}
		
		
	
}
