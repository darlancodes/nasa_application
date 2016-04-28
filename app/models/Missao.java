package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.avaje.ebean.Model;
import models.Planeta;
import models.Espaconave;
import play.data.validation.Constraints.*;

@Entity
public class Missao extends Model{
	
	@Id
	@GeneratedValue
	public Long id;
	
	@ManyToOne
	public Planeta planeta;
	
	@ManyToOne
	public Espaconave espaconave;
	
	@Required
	public Date lancamento;
	@Required
	public Boolean tripulada;
	@Required
	public float orcamento;
	
	public Missao(){
		
	}
	
	public Missao(Long id, Planeta planeta, Espaconave espaconave, Date lancamento, Boolean tripulada, float orcamento){
		
		this.id = id;
		this.planeta = planeta;
		this.lancamento = lancamento;
		this.espaconave = espaconave;
		this.lancamento = lancamento;
		this.tripulada = tripulada;
		this.orcamento = orcamento;
		
	}
	
	public static Finder<Long, Missao> find = new Finder<Long,Missao>(Missao.class);
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

	public Espaconave getEspaconave() {
		return espaconave;
	}

	public void setEspaconave(Espaconave espaconave) {
		this.espaconave = espaconave;
	}

	public Date getLancamento() {
		return lancamento;
	}

	public void setLancamento(Date lancamento) {
		this.lancamento = lancamento;
	}

	public Boolean getTripulada() {
		return tripulada;
	}

	public void setTripulada(Boolean tripulada) {
		this.tripulada = tripulada;
	}

	public float getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}

}
