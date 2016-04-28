package controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.Missao;
import models.MissaoStaging;
import models.Planeta;
import models.Espaconave;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class MissoesStaging extends Controller{

	
		private final Form<MissaoStaging> formMissaoStaging = Form.form(MissaoStaging.class);
		private final Form<Missao> formMissao = Form.form(Missao.class);
		
		
		public Result novo()
		{
			List<Espaconave> espaconaves = Espaconave.find.all();
			List<Planeta> planetas = Planeta.find.all();
			return ok(views.html.aplicacao.missoes.render(formMissaoStaging,planetas,espaconaves));
		}
		
		/*Com o controller MissoesStaging eu consigo salvar o objeto planeta e espaconave 
		 dentro do objeto Missao, de acordo com o id que o usuário digitou no form Missao.
		 Criei o modelo MissaoStaging, que recebe em vez do objeto planeta e espaconave, um 
		 Long que corresponde ao id do planeta e id da espaconave. (gambiarra :/)
		 */
		
		public Result exibir_editar(Long id)
		{
			List<Espaconave> espaconaves = Espaconave.find.all();
			List<Planeta> planetas = Planeta.find.all();
			Missao missao = Missao.find.byId(id);
			
			MissaoStaging missaoStaging = new MissaoStaging();
			
			missaoStaging.setEspaconave_id(missao.getEspaconave().getId());
			missaoStaging.setPlaneta_id(missao.getPlaneta().getId());
			missaoStaging.setId(missao.getId());
			missaoStaging.setLancamento(missao.getLancamento());
			missaoStaging.setOrcamento(missao.getOrcamento());
			missaoStaging.setTripulada(missao.getTripulada());
			
			
			Form<MissaoStaging> formPlanetaPreenchido = formMissaoStaging.fill(missaoStaging);
			return ok(views.html.aplicacao.missoesUpdate.render(formPlanetaPreenchido,planetas,espaconaves));
		}
		
		public Result salvar()
		{
			
			Form<MissaoStaging> formEnviado = formMissaoStaging.bindFromRequest();
	
			if(formEnviado.hasErrors()){
			 flash("error", "Por favor corrija o formulário abaixo");
			 //return ok(views.html.produtos.detalhes.render(formEnviado));
			}
			
			MissaoStaging missaoStaging = formEnviado.get();
			
			Missao missao = new Missao();
			
			Long e = missaoStaging.getEspaconave_id();
			Long p = missaoStaging.getPlaneta_id();
			
			Espaconave espaconave= Espaconave.find.byId(e);
			Planeta planeta = Planeta.find.byId(p);
			
			missao.setEspaconave(espaconave);
			missao.setPlaneta(planeta);
			
			missao.setId(missaoStaging.getId());
			missao.setLancamento(missaoStaging.getLancamento());
			missao.setOrcamento(missaoStaging.getOrcamento());
			missao.setTripulada(missaoStaging.getTripulada());
			
			missao.save();
			
			List<Espaconave> espaconaves = Espaconave.find.all();
			List<Planeta> planetas = Planeta.find.all();
			return ok(views.html.aplicacao.missoes.render(formMissaoStaging,planetas,espaconaves));
		}
			
		public Result update()
		{
			
			Form<MissaoStaging> formEnviado = formMissaoStaging.bindFromRequest();
	
			if(formEnviado.hasErrors()){
			 flash("error", "Por favor corrija o formulário abaixo");
			 //return ok(views.html.produtos.detalhes.render(formEnviado));
			}
			
			MissaoStaging missaoStaging = formEnviado.get();
			
			Missao missao = new Missao();
			
			Long e = missaoStaging.getEspaconave_id();
			Long p = missaoStaging.getPlaneta_id();
			
			Espaconave espaconave= Espaconave.find.byId(e);
			Planeta planeta = Planeta.find.byId(p);
			
			missao.setEspaconave(espaconave);
			missao.setPlaneta(planeta);

			
			missao.setId(missaoStaging.getId());
			missao.setLancamento(missaoStaging.getLancamento());
			missao.setOrcamento(missaoStaging.getOrcamento());
			missao.setTripulada(missaoStaging.getTripulada());
			
			missao.update();
			
			List<Espaconave> espaconaves = Espaconave.find.all();
			List<Planeta> planetas = Planeta.find.all();
			List<Missao> missoes = Missao.find.all();
			return ok(views.html.listamissoes.render(formMissao,missoes,planetas,espaconaves));
		}
		
	
}
