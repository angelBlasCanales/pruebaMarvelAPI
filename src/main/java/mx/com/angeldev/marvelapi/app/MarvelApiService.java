package mx.com.angeldev.marvelapi.app;

import org.springframework.http.ResponseEntity;

import mx.com.angeldev.marveljar.model.CharacterDataWrapper;

public interface MarvelApiService {
	
	public ResponseEntity<CharacterDataWrapper> getAllCharacters();
	
	public ResponseEntity<CharacterDataWrapper> getCharacterById(Long id);

}
