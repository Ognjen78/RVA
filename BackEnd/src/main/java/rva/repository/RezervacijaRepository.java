package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Rezervacija;
import rva.model.Sala;

public interface RezervacijaRepository extends JpaRepository <Rezervacija, Long> {
	
	
	List<Rezervacija> findBySala(Sala sala);
	List<Rezervacija> findByPlacenoIsTrue();
	List<Rezervacija> findByBrojOsobaGreaterThan(long brojOsoba);	
	

}
