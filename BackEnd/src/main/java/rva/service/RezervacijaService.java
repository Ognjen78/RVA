package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Rezervacija;
import rva.model.Sala;
import rva.repository.RezervacijaRepository;

@Service
public class RezervacijaService {
	
	@Autowired
	private RezervacijaRepository repo;
	
	public List<Rezervacija> getAll(){
		return repo.findAll();
	}

	public Optional<Rezervacija> getById(long id){
		return repo.findById(id);
	}
	
	public List<Rezervacija> findByPlacenoIsTrue() {
        return repo.findByPlacenoIsTrue();
    }

	
	
	public List<Rezervacija> getByBrojOsobaGreaterThan(long brojOsoba){
		return repo.findByBrojOsobaGreaterThan(brojOsoba);
	}
	
	public Optional<List<Rezervacija>> getBySala(Sala sala){
		Optional <List<Rezervacija>> lista = Optional.of(repo.findBySala(sala));
		return lista;
	}
	
	public Rezervacija save(Rezervacija rezervacija) {
		return repo.save(rezervacija);
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
