package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;
import play.data.validation.Constraints.*;
import play.mvc.Result;

@Entity
public class Planeta extends Model {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Required
	public String nome;
	@Required
	public String sistema;
	@Required
	public Boolean habitavel;
	
	@OneToMany(mappedBy="planeta")
	public List<Missao> missao = new ArrayList<>();
	
	
	public Planeta(){
		
	}
	
	public Planeta(Long id, String nome, String sistema, Boolean habitavel){
		
		this.id =id;
		this.nome = nome;
		this.sistema = sistema;
		this.habitavel = habitavel;
		
	}
	
	public static Finder<Long, Planeta> find = new Finder<Long,Planeta>(Planeta.class);
	
	//List<Planeta> planetas = Planeta.find.all();
	
	/*public Result lista()
	{
		List<Planeta> planetas = Planeta.find.all();
		return ok(views.html.home.render(planetas));
	}*/

	
	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public Boolean getHabitavel() {
		return habitavel;
	}

	public void setHabitavel(Boolean habitavel) {
		this.habitavel = habitavel;
	}

	
	

	
}
