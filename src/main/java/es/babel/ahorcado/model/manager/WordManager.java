package es.babel.ahorcado.model.manager;

import es.babel.ahorcado.model.entities.Subject;
import es.babel.ahorcado.model.entities.Word;
import es.babel.ahorcado.model.persistance.ThemeDao;
import es.babel.ahorcado.model.persistance.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WordManager {

    @Autowired
    WordDao wordDao;

    @Autowired
    ThemeDao themeDao;

    public Word insert(String word, String theme) {
        Subject s = themeDao.findByTheme(theme);
        if(s == null) {
            s = new Subject(theme);
            themeDao.save(s);
        }
        Word w = new Word(word, s);
        return wordDao.save(w);
    }

    public List<Word> findAllByTheme(String theme) {
        return wordDao.findAllByTheme(themeDao.findByTheme(theme));
    }

    public Word findRandomWordByTheme(String theme) {
        List<Word> list = wordDao.findAllByTheme(themeDao.findByTheme(theme));
        if(list.size() > 0) {
            Collections.shuffle(list);
            return list.get(0);
        }
        return null;
    }

}
