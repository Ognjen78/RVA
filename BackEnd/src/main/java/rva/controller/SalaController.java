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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Bioskop;
import rva.model.Sala;
import rva.service.BioskopService;
import rva.service.SalaService;


@CrossOrigin
@RestController
@RequestMapping("sala")
public class SalaController {
	
	@Autowired
	private SalaService service;
	
	@Autowired
	private BioskopService bioskopService;
	
	@GetMapping
	public ResponseEntity<List<Sala>> getAllSala(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getSalaById(@PathVariable long id){
		if(service.getById(id).isPresent()) {
			return ResponseEntity.ok(service.getById(id).get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested ID: " + id + " has not been found");
		}
	}
	
	@GetMapping("/kapacitet/{kapacitet}")
	public ResponseEntity<?> getKapacitetByIzosGreaterThan(@PathVariable long kapacitet){
		Optional<List<Sala>> lista = service.getByKapacitetGreaterThan(kapacitet);
		if(!lista.get().isEmpty()) {
			return ResponseEntity.ok(lista.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Resources with iznos greater than: " + kapacitet + " have not been found");
		}
	}
	
	@GetMapping("/bioskop/{id}")
	public ResponseEntity<?> getSalaByBioskop(@PathVariable long id){
		Optional<Bioskop> bioskop = bioskopService.getById(id);
		if(bioskop.isPresent()) {
			List<Sala> lista = service.getByBioskop(bioskop.get()).get();
			if(!lista.isEmpty()) {
				return ResponseEntity.ok(lista);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resources with requested foreign key : " + id + 
								" do not exist");
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bioskop with ID: " + id + " does not exist");
		}

	}
	
	@PostMapping
	public ResponseEntity<Sala> createSala(@RequestBody Sala sala){
		Sala savedSala;
		if(!service.existsById(sala.getId())) {
			savedSala = service.save(sala);
		}
		else {
			List<Sala> lista = service.getAll();
			long najvecaVrednost = 1;
			for(int i = 0; i< lista.size(); i++) {
				if(najvecaVrednost <= lista.get(i).getId()) {
					najvecaVrednost = lista.get(i).getId();
				}

				if(i == lista.size() - 1) {
					najvecaVrednost++;
				}

			}
			sala.setId(najvecaVrednost);
			savedSala = service.save(sala);

		}
		URI uri = URI.create("/sala/" + savedSala.getId());
		return ResponseEntity.created(uri).body(savedSala);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateSala(@RequestBody Sala sala, @PathVariable long id){
		if(service.existsById(id)) {
			sala.setId(id);
			Sala savedSala = service.save(sala);
			return ResponseEntity.ok(savedSala);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested ID: " + id + " has not been found");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSala(@PathVariable long id){
		if(service.existsById(id)) {
			service.deleteById(id);
			return ResponseEntity.ok("Resource with ID: " + id + " has been deleted");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with ID: " + id + " has not been found");
		}
	}


	

}
