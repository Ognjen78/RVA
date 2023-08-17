package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Bioskop;
import rva.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
	
	List<Sala> findByKapacitetGreaterThan(long kapacitet);
	
	List<Sala> findByBioskop(Bioskop bioskop);
	
	

}
