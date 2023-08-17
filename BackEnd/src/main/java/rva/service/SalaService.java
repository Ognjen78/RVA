package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Bioskop;
import rva.model.Sala;
import rva.repository.SalaRepository;

@Service
public class SalaService {
	
	@Autowired 
	private SalaRepository repo;
	
	public List<Sala> getAll() {
		return repo.findAll();
	}
	
	public Optional <Sala> getById(long id) {
		return repo.findById(id);
	}
	
	public Optional<List<Sala>> getByKapacitetGreaterThan(long kapacitet){
		return Optional.of(repo.findByKapacitetGreaterThan(kapacitet));
	}
	
	public Optional<List<Sala>> getByBioskop(Bioskop bioskop){
		return Optional.of(repo.findByBioskop(bioskop));
	}
	
	public Sala save(Sala sala) {
		return repo.save(sala);
	}
	
	public boolean existsById(long id) {
		if(getById(id).isPresent()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void deleteById(long id) {
		repo.deleteById(id);
	}


}
