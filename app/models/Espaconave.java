package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;
import play.data.validation.Constraints.*;

@Entity
public class Espaconave extends Model{
	
	@Id
	@GeneratedValue
	public Long id;
	@Required
	public String modelo;
	@Required
	public String pais;
	
	@OneToMany(mappedBy="espaconave")
	public List<Missao> missao = new ArrayList<>();
	
	public Espaconave(){
		
	}
	
	public Espaconave(Long id, String modelo, String pais){
		
		this.id = id;
		this.modelo = modelo;
		this.pais = pais;
		
	}
	
	public static Finder<Long, Espaconave> find = new Finder<Long,Espaconave>(Espaconave.class);
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	

}
