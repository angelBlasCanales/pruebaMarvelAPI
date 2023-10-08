package mx.com.angeldev.marvelapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.angeldev.marvelapi.app.BitacoraService;
import mx.com.angeldev.marvelapi.app.MarvelApiService;
import mx.com.angeldev.marvelapi.dao.BitacoraEntity;
import mx.com.angeldev.marveljar.model.Character;

@RestController
@RequestMapping("public/marvel/characters")
@CrossOrigin(origins="http://localhost:4200")
public class MarvelApiController {
	
	@Autowired
	private MarvelApiService marvelApiService;
	
	@Autowired
	private BitacoraService bitacoraService;
	
	
	@GetMapping("/")
	public ResponseEntity<Character[]> getAllCharacters() throws Exception {
		bitacoraService.saveBitacora("all characters");
		return marvelApiService.getAllCharacters();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Character> getCharacterById(@PathVariable Long id)throws Exception {
		bitacoraService.saveBitacora("character info");
		return marvelApiService.getCharacterById(id);	
	}
	
	@GetMapping("/bitacora")
	public List<BitacoraEntity> getBitacora(){
		return bitacoraService.getAll();
	}

}
