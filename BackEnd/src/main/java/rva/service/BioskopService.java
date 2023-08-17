package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Bioskop;
import rva.repository.BioskopRepository;

@Service
public class BioskopService {
	
	@Autowired
	private BioskopRepository repo;
	
	public Optional<Bioskop> getById(long id) {
		return repo.findById(id);
	}
	
	public List<Bioskop> findAll() {
		
		return repo.findAll();
		
	}
	
	public Optional<Bioskop> findById(long id){
		
		return repo.findById(id);
		
	}
	
	public Optional<List<Bioskop>> findByNaziv(String naziv) {
		
		Optional<List<Bioskop>> lista = Optional.of(repo.findByNazivContainingIgnoreCase(naziv)) ;
		return lista;
		
	}
	
	
	public Bioskop save(Bioskop bioskop) {
		
		return repo.save(bioskop);
		
	}
	
	public boolean existsById(long id) {
		
		if (findById(id).isPresent()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void deleteById(long id) {
		
		repo.deleteById(id);
	}
		

}
