package mx.com.angeldev.marvelapi.controller;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.angeldev.marvelapi.app.MarvelApiService;
import mx.com.angeldev.marveljar.model.CharacterDataWrapper;

@RestController
@RequestMapping("/marvel/characters")
public class MarvelApiController {
	
	@Autowired
	private MarvelApiService marvelApiService;
	
	@GetMapping("/")
	public ResponseEntity<CharacterDataWrapper> getAllCharacters() {
		return marvelApiService.getAllCharacters();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CharacterDataWrapper> getCharacterById(@PathVariable 
			@Pattern(regexp = "\\d+", message = "El ID debe contener solo números") Long id){
		return marvelApiService.getCharacterById(id);
	}

}
