package mx.com.angeldev.marvelapi.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.angeldev.marveljar.app.MarvelJarService;
import mx.com.angeldev.marveljar.model.CharacterDataWrapper;

@Service
public class MarvelApiServiceImpl implements MarvelApiService {
	
	@Autowired
	private MarvelJarService marvelJarService;

	@Override
	public ResponseEntity<CharacterDataWrapper> getAllCharacters() {
		try {
            CharacterDataWrapper dw = marvelJarService.getAllCharacters();
            return ResponseEntity.ok(dw);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}

	@Override
	public ResponseEntity<CharacterDataWrapper> getCharacterById(Long id) {
		try {
            CharacterDataWrapper dw = marvelJarService.getCharacterById(id);
            return ResponseEntity.ok(dw);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}

}
