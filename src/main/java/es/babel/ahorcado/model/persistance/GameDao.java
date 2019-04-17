package es.babel.ahorcado.model.persistance;

import es.babel.ahorcado.model.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDao extends JpaRepository<Game, Integer> {
    public Game findById(int id);
}
