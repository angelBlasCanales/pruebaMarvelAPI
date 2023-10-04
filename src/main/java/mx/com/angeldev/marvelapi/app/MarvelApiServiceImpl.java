package mx.com.angeldev.marvelapi.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.angeldev.marveljar.app.MarvelJarService;
import mx.com.angeldev.marveljar.model.Character;
import mx.com.angeldev.marveljar.model.CharacterDataWrapper;

@Service
public class MarvelApiServiceImpl implements MarvelApiService {
	
	@Autowired
	private MarvelJarService marvelJarService;

	@Override
	public ResponseEntity<Character[]> getAllCharacters() throws Exception {
        CharacterDataWrapper dw = marvelJarService.getAllCharacters();
        if (HttpStatus.OK.value() != dw.getCode()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
        return ResponseEntity.ok(dw.getData().getResults());
	}

	@Override
	public ResponseEntity<Character> getCharacterById(Long id) throws Exception {
        CharacterDataWrapper dw = marvelJarService.getCharacterById(id);
        if (HttpStatus.OK.value() != dw.getCode()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
        return ResponseEntity.ok(dw.getData().getResults()[0]);
	}

}
