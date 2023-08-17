package rva.controller;

import java.util.List;

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
import java.net.URI;
import org.springframework.web.bind.annotation.CrossOrigin;

import rva.model.Bioskop;
import rva.service.BioskopService;

@CrossOrigin
@RestController
public class BioskopController {
	
	@Autowired
	private BioskopService service;
	
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/bioskop")
	public ResponseEntity<List<Bioskop>> findAllBioskop(){
		
		return ResponseEntity.ok(service.findAll());
	}
	
	
	@GetMapping("/bioskop/{id}")
	public ResponseEntity<?> getBioskopById(@PathVariable long id) {
		
		if ( service.existsById(id) ) {
			
			return ResponseEntity.ok(service.findById(id));
		}
		else { 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested ID: " + id + " does not exist");
			
		}
			
		
	}
	
	
	@GetMapping ("/bioskop/naziv/{naziv}")
	public ResponseEntity<?> getBioskopByNaziv (@PathVariable String naziv) {
		
		if (service.findByNaziv(naziv).get().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested name :" + naziv + " does not exist");
		}
		else {
			return ResponseEntity.ok(service.findByNaziv(naziv).get());
		}
	}
	 
	
	@PostMapping("/bioskop")
	public ResponseEntity<?> createBioskop(@RequestBody Bioskop bioskop){
		Bioskop savedBioskop;
		if(!service.existsById(bioskop.getId())) {
			savedBioskop  = service.save(bioskop);
		} else {
			List<Bioskop> lista = service.findAll();
			long najvecaVrednost = 1;
			for (int i = 0; i < lista.size(); i++) {
				if (najvecaVrednost <= lista.get(i).getId()) {
					najvecaVrednost = lista.get(i).getId();
				}
				
				if (i == lista.size() - 1) {
					najvecaVrednost++;
				}
			}
			
			bioskop.setId(najvecaVrednost);
			savedBioskop = service.save(bioskop);
		}
		URI uri = URI.create("/bioskop/" + savedBioskop.getId());
		return ResponseEntity.created(uri).body(savedBioskop);
	}
	
	@PutMapping("/bioskop/{id}")
	public ResponseEntity<?> updateBioskop( @RequestBody Bioskop bioskop, @PathVariable long id){
		
		if(service.existsById(id)) {
			bioskop.setId(id);
			Bioskop updatedBioskop = service.save(bioskop);
			return ResponseEntity.ok(updatedBioskop);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bioskop with id " + id + " has not been found");
		}		
		
		
	}
	
	@DeleteMapping("/bioskop/{id}")
	public ResponseEntity<?> deleteBioskop(@PathVariable long id){
		if(service.existsById(id)) {
			service.deleteById(id);
			return ResponseEntity.ok("Resource with ID: " + id + " has been deleted");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with ID: " + id + " has not been found");
		}
	}



}
