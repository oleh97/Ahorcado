package es.babel.ahorcado.model.persistance;

import es.babel.ahorcado.model.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeDao extends JpaRepository<Subject, Integer> {
    public Subject findByTheme(String theme);
}
