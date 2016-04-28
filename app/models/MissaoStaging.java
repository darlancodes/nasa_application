package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.avaje.ebean.Model;
import play.data.validation.Constraints.*;


public class MissaoStaging extends Model{

	public Long id;
	
	
	public Long planeta_id;
	

	public Long espaconave_id;
	

	public Date lancamento;

	public Boolean tripulada;

	public float orcamento;
	
	public MissaoStaging(){
		
	}
	
	public MissaoStaging(Long id, Long planeta_id, Long espaconave_id, Date lancamento, Boolean tripulada, float orcamento){
		
		this.id = id;
		this.planeta_id = planeta_id;
		this.lancamento = lancamento;
		this.espaconave_id = espaconave_id;
		this.lancamento = lancamento;
		this.tripulada = tripulada;
		this.orcamento = orcamento;
		
	}
	
	public static Finder<Long, MissaoStaging> find = new Finder<Long,MissaoStaging>(MissaoStaging.class);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlaneta_id() {
		return planeta_id;
	}

	public void setPlaneta_id(Long planeta_id) {
		this.planeta_id = planeta_id;
	}

	public Long getEspaconave_id() {
		return espaconave_id;
	}

	public void setEspaconave_id(Long espaconave_id) {
		this.espaconave_id = espaconave_id;
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
