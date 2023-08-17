package rva.controller;

import java.net.URI;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
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

import rva.model.Bioskop;
import rva.model.Rezervacija;
import rva.model.Sala;
import rva.service.RezervacijaService;
import rva.service.SalaService;

@CrossOrigin
@RestController
public class RezervacijaController {
	
	@Autowired
	private RezervacijaService service;
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping("/rezervacija")
	public List<Rezervacija> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/rezervacija/{id}")
	public ResponseEntity<?> getRezervacijaById(@PathVariable long id) {
		
		if (service.getById(id).isPresent()) {
			Rezervacija rezervacija = service.getById(id).get();
			return ResponseEntity.ok(rezervacija);
		}
		else { 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested ID: " + id + " does not exist");
			
		}
	}
	
	@GetMapping("/rezervacija/brojOsoba/{brojOsoba}")
	public ResponseEntity<?> findRezervacijaByBrojOsobaGreaterThan(@PathVariable long brojOsoba) {
		if (!service.getByBrojOsobaGreaterThan(brojOsoba).isEmpty()) {
			return ResponseEntity.ok(service.getByBrojOsobaGreaterThan(brojOsoba));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Resources with broj osoba greater than " + brojOsoba + "have not been found.");
			
		}
	}
	
	@GetMapping("/rezervacija/sala/{id}")
	public ResponseEntity<?> getRezervacijaBySala(@PathVariable long id){
		
		if(!service.getBySala(salaService.getById(id).get()).get().isEmpty()) {
			
				return ResponseEntity.ok(service.getBySala(salaService.getById(id).get()).get());
				
			}else {
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Resources with requested foreign key : " + id + 
								" do not exist");
			}
		

	}
	
	@PostMapping
	public ResponseEntity<Rezervacija> createRezervacija(@RequestBody Rezervacija rezervacija){
		Rezervacija savedRezervacija;
		if(!service.existsById(rezervacija.getId())) {
			savedRezervacija = service.save(rezervacija);
		}
		else {
			List<Rezervacija> lista = service.getAll();
			long najvecaVrednost = 1;
			for(int i = 0; i< lista.size(); i++) {
				if(najvecaVrednost <= lista.get(i).getId()) {
					najvecaVrednost = lista.get(i).getId();
				}

				if(i == lista.size() - 1) {
					najvecaVrednost++;
				}

			}
			rezervacija.setId(najvecaVrednost);
			savedRezervacija = service.save(rezervacija);

		}
		URI uri = URI.create("/rezervacija/" + savedRezervacija.getId());
		return ResponseEntity.created(uri).body(savedRezervacija);
	}
	
	
	@PutMapping("/rezervacija/{id}")
	public ResponseEntity<?> updateRezervacija(@RequestBody Rezervacija rezervacija, @PathVariable long id){
		if(service.existsById(id)) {
			rezervacija.setId(id);
			Rezervacija savedRezervacija = service.save(rezervacija);
			return ResponseEntity.ok(savedRezervacija);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested ID: " + id + " has not been found");
		}
	}
	
	@DeleteMapping("/rezervacija/{id}")
	public ResponseEntity<String> deleteRezervacija(@PathVariable long id){
		if(service.existsById(id)) {
			service.deleteById(id);
			return ResponseEntity.ok("Resource with ID: " + id + " has been deleted");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with ID: " + id + " has not been found");
		}
	}
	

}
