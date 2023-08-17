package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Film;
import rva.repository.FilmRepository;

@Service
public class FilmService {
	/*
	 * Anotacija koja predstavlja Dependency Injection. 
	 * Moze biti navedena iznad reference, set metode ili konstruktora
	 * U ovom slucaju, kada je navedena iznad reference tipa interfejsa
	 * Spring kontejner kreira anonimnu klasu koja implementira interfejs i njegove metode, 
	 * instancira objekat anonimne klase i referencu na taj objekat injektuje u referencu nad
	 * kojom se ova anotacija nalazi. U slucaju obicne klase se samo vrsi instanciranje objekta
	 * i injektovanje reference na taj objekat
	 * */
	@Autowired
	private FilmRepository repo;
	
	public Optional<Film> getFilmById(long id) {
		return repo.findById(id);
	}
	
	public List<Film> getAllFilm() {
		return repo.findAll();
	}
	
    public Optional<List<Film>> findByNazivFilma(String naziv) {
		
		Optional<List<Film>> listaFilm = Optional.of(repo.findByNazivContainingIgnoreCase(naziv)) ;
		return listaFilm;
		
	}
    
    public Optional<List<Film>> getByRecenzijaGreaterThan(long recenzija){
		Optional<List<Film>> listaFilm = Optional.of(repo.findByRecenzijaGreaterThan(recenzija));
		return listaFilm;
	}
    
    
    
    
    public boolean existsById(long id) {
		
		if (getFilmById(id).isPresent()) {
			return true;
		} else {
			return false;
		}
	}
	
    
	public Film save(Film film) {
		
		return repo.save(film);
		
	}
    
    public void deleteById(long id) {
		
		repo.deleteById(id);
	}
    
    public Film addFilm(Film film) {
    	return repo.save(film);
    }



	

}
