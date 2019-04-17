package es.babel.ahorcado.model.manager;

import es.babel.ahorcado.model.entities.Game;
import es.babel.ahorcado.model.entities.Word;
import es.babel.ahorcado.model.persistance.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameManager {

    @Autowired
    GameDao gameDao;

    public Game insert(Word word) {
        Game g = new Game();
        g.setLost(false);
        g.setTries(5);
        g.setWord(word);
        g.setGuessWord(word.getWord().replaceAll("[a-zA-Z]", "-"));
        return gameDao.save(g);
    }

    public Game modifyLetter(int id, String letter) {
        Game g = gameDao.findById(id);
        if(g != null) {
            if(g.checkLetter(letter) >= 0) {
                g.replaceGuessWord(letter);
                if(g.checkGuessWordLetter("-")< 0) {
                    g.setLost(true);
                }
            }
            else {
                g.setTries(g.getTries()-1);
            }
            return gameDao.save(g);
        }
        return null;
    }

    public Game modifyWord(int id, String word) {
        Game g = gameDao.findById(id);
        if(g != null) {
            if(g.getWord().getWord().equals(word)) {
                g.setLost(true);
                g.setGuessWord(g.getWord().getWord());
            }
            else {
                g.setTries(g.getTries()-1);
            }
            return gameDao.save(g);
        }
        return null;
    }

    public Game findGame(int id) {
        return gameDao.findById(id);
    }

}
