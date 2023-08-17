package rva.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity

public class Sala implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SALA_ID_GENERATOR", sequenceName = "SALA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALA_ID_GENERATOR")
	private long id;
	private long kapacitet;
	private long brojRedova;
	
	@ManyToOne
	@JoinColumn(name = "bioskop")
	private Bioskop bioskop;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sala", cascade = CascadeType.REMOVE)
	private List<Rezervacija> rezervacija;
	
	public Sala() {
		
	}
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getKapacitet() {
		return kapacitet;
	}
	
	public void setKapacitet(long kapacitet) {
		this.kapacitet = kapacitet;
	}
	
	public long getBrojRedova() {
		return brojRedova;
	}
	
	public void setBrojRedova(long brojRedova) {
		this.brojRedova = brojRedova;
	}
	
	public Bioskop getBioskop() {
		return bioskop;
	}
	
	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}
	
	public List<Rezervacija> getRezervacija() {
		return rezervacija;
	}
	
	public void setRezervacija(List<Rezervacija> rezervacija) {
		this.rezervacija = rezervacija; 
	}
}
