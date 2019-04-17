package es.babel.ahorcado.model.persistance;

import es.babel.ahorcado.model.entities.Subject;
import es.babel.ahorcado.model.entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordDao extends JpaRepository<Word, Integer> {
    public List<Word> findAllByTheme(Subject theme);
}
