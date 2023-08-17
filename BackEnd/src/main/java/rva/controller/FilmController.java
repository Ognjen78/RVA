package rva.controller;

import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Film;
import rva.service.FilmService;

@CrossOrigin
@RestController
public class FilmController {
	
	
	@Autowired
	private FilmService service;
	
	@GetMapping("/film")
	public ResponseEntity<List<Film>> findAllFilm(){
		
		return ResponseEntity.ok(service.getAllFilm());
	}
	
	@GetMapping("/film/{id}")
	public ResponseEntity<?> getFilmById(@PathVariable long id) {
		
		if (service.existsById(id)) {
			
			return ResponseEntity.ok(service.getFilmById(id).get());
		}
		else { 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested ID: " + id + " does not exist");
			
		}
			
		
	}
	
	@GetMapping ("/film/naziv/{naziv}")
	public ResponseEntity<?> getFilmByNaziv(@PathVariable String naziv) {
		
		
		if (service.findByNazivFilma(naziv).get().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested name :" + naziv + " does not exist");
		}
		else {
			return ResponseEntity.ok(service.findByNazivFilma(naziv).get());
		}
	}
	
	
	@GetMapping("/film/recenzija/{recenzija}")
	public ResponseEntity<?> getFilmByRecenzijaGreaterThan(@PathVariable long recenzija){
		Optional<List<Film>> lista = service.getByRecenzijaGreaterThan(recenzija);
		if(!lista.get().isEmpty()) {
			return ResponseEntity.ok(lista.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resources with iznos greater than: " + recenzija + " have not been found");
		}
	}
	
	
	
	
	@PostMapping("/film")
	public ResponseEntity<?> createFilm(@RequestBody Film film){
		Film savedFilm;
		if(!service.existsById(film.getId())) {
			savedFilm = service.addFilm(film);
		} else {
				List<Film> lista = service.getAllFilm();
				long najvecaVrednost = 1;
				for (int i = 0; i < lista.size(); i++) {
					if (najvecaVrednost <= lista.get(i).getId()) {
						najvecaVrednost = lista.get(i).getId();
					}
					
					if (i == lista.size()-1) {
						najvecaVrednost++;
					}
				}
				
				film.setId(najvecaVrednost);
				savedFilm = service.addFilm(film);
			
		}
		
		URI uri = URI.create("/film/" + savedFilm.getId());
		return ResponseEntity.created(uri).body(savedFilm);
	}
	
	@PutMapping("/film/{id}")
	public ResponseEntity<?> updateFilm(@PathVariable long id, 
			@RequestBody Film film){
		
		if(!service.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film with id " + film.getId() + " not found");
		} else {
			film.setId(id);
			Film updatedFilm = service.addFilm(film);
			return ResponseEntity.ok(updatedFilm);
			
		}
		
	}
	
	@DeleteMapping("/film/{id}")
	public ResponseEntity<String> deleteFilm(@PathVariable long id){
		if(service.existsById(id)) {
			service.deleteById(id);
			return ResponseEntity.ok("Film with ID: " + id + " has been deleted");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film with ID: " + id + " has not been found");
		}
	}
	
	
	

}
