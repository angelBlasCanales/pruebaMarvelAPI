package mx.com.angeldev.marvelapi.app;

import org.springframework.http.ResponseEntity;

import mx.com.angeldev.marveljar.model.Character;

public interface MarvelApiService {
	
	public ResponseEntity<Character[]> getAllCharacters() throws Exception;
	
	public ResponseEntity<Character> getCharacterById(Long id) throws Exception;

}
