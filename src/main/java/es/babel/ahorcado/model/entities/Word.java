package es.babel.ahorcado.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "words")
public class Word {
    private String word;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Subject theme;

    public Word(String word, Subject theme) {
        this.word = word;
        this.theme = theme;
    }

    public Word() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getTheme() {
        return theme;
    }

    public void setTheme(Subject theme) {
        this.theme = theme;
    }
}
