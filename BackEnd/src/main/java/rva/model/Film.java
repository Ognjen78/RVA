package rva.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity

public class Film implements Serializable	{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "FILM_ID_GENERATOR", sequenceName = "FILM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILM_ID_GENERATOR")
	private long id;
	private String naziv;
	private long recenzija;
	private long trajanje;
	private String zanr;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="film", cascade = CascadeType.REMOVE)
	private List<Rezervacija> rezervacija;
	
	public Film() {
	
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public long getRecenzija() {
		return recenzija;
	}
	
	public void setRecenzija(long recenzija) {
		this.recenzija = recenzija;
	}
	
	public long getTrajanje() {
		return trajanje;
	}
	
	public void setTrajanje(long trajanje) {
		this.trajanje = trajanje;
	}
	
	public String getZanr() {
		return zanr;
	}
	
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	
	
	
	
	
}
