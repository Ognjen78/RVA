package rva.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;


@Entity

public class Rezervacija implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "REZERVACIJA_ID_GENERATOR", sequenceName = "REZERVACIJA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REZERVACIJA_ID_GENERATOR")
	private long id;
	private long brojOsoba;
	private double cenaKarte;
	private Date datum;
	private Boolean placeno;
	
	@ManyToOne
	@JoinColumn(name="sala")
	private Sala sala;
	
	@ManyToOne
	@JoinColumn(name="film")
	private Film film;
	
	public Rezervacija()
	{
		
	}
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getBrojOsoba() {
		return brojOsoba;
	}
	
	public void setBrojOsoba(long brojOsoba) {
		this.brojOsoba = brojOsoba;
	}
	
	public double getCenaKarte() {
		return cenaKarte;
	}
	
	public void setCenaKarte(double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}
	
	public Date getDatum() {
		return datum;
	}
	
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public Boolean getPlaceno() {
		return placeno;
	}
	
	public void setPlaceno(Boolean placeno) {
		this.placeno = placeno;
	}
	
	public Sala getSala() {
		return sala;
	}
	
	public Film getFilm() {
		return film;
	}
	
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public void setFilm(Film film) {
		this.film = film;
	}

}
