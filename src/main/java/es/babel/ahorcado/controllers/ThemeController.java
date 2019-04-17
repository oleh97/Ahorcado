package es.babel.ahorcado.controllers;

import es.babel.ahorcado.model.entities.Subject;
import es.babel.ahorcado.model.entities.Word;
import es.babel.ahorcado.model.manager.ThemeManager;
import es.babel.ahorcado.model.manager.WordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class ThemeController {

    @Autowired
    ThemeManager manager;

    @Autowired
    WordManager wordManager;

    @GetMapping("temas")
    public ResponseEntity<List<Subject>> findAllThemes() {
        return new ResponseEntity<>(manager.findAll(), HttpStatus.OK);
    }

    @PostMapping("temas")
    public ResponseEntity<Subject> setTheme(
            @RequestParam(name = "themeName") String themeName
    ) {
        return new ResponseEntity<>(manager.insert(new Subject(themeName)), HttpStatus.CREATED);
    }


    @PostMapping("temas/{tema}")
    public ResponseEntity<Word> insertWordIntoTheme(
            @PathVariable("tema") String theme,
            @RequestParam(name = "wordName") String wordName
    ) {
        return new ResponseEntity<>(wordManager.insert(wordName, theme), HttpStatus.CREATED);
    }

    @GetMapping("temas/{tema}")
    public ResponseEntity<List<Word>> findAllWordsByTheme(
            @PathVariable("tema") String theme
    ) {
        List<Word> wordList = wordManager.findAllByTheme(theme);
        if(wordList == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(wordList, HttpStatus.OK);
    }

    @GetMapping("temas/{tema}/palabraAleatoria")
    public ResponseEntity<Word> findRandomWordByTheme(
            @PathVariable("tema") String theme
    ) {
        Word w = wordManager.findRandomWordByTheme(theme);
        if(w == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(w, HttpStatus.OK);
    }

}
