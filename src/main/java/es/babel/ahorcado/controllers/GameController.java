package es.babel.ahorcado.controllers;

import es.babel.ahorcado.model.entities.ClientGameDTO;
import es.babel.ahorcado.model.entities.Game;
import es.babel.ahorcado.model.entities.Word;
import es.babel.ahorcado.model.manager.GameManager;
import es.babel.ahorcado.model.manager.WordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class GameController {

    @Autowired
    GameManager gameManager;

    @Autowired
    WordManager wordManager;

    @PostMapping("partida")
    public ResponseEntity<ClientGameDTO> setNewGame(
            @RequestParam(name = "themeName") String themeName
    ) {
        Word w = wordManager.findRandomWordByTheme(themeName);
        Game g = gameManager.insert(w);
        ClientGameDTO clientGameDTO = new ClientGameDTO(g.getGuessWord(), g.getTries(), g.isLost(), g.getId());
        return new ResponseEntity<>(clientGameDTO, HttpStatus.CREATED);
    }

    @PutMapping("partida/{id}")
    public  ResponseEntity<ClientGameDTO> modifyLetterGame(
            @PathVariable("id") int id,
            @RequestParam(name = "letter") String letter
    ) {
        Game g;
        if(letter.length() > 1) {
            g = gameManager.modifyWord(id, letter);
        }
        else{
            g = gameManager.modifyLetter(id, letter);
        }
        ClientGameDTO clientGameDTO = new ClientGameDTO(g.getGuessWord(), g.getTries(), g.isLost(), g.getId());
        return new ResponseEntity<>(clientGameDTO, HttpStatus.CREATED);
    }

}
