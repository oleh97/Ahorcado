package es.babel.ahorcado.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "themes")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 //   @Column(unique = true)
    private String theme;

    public Subject(String theme, int id) {
        this.id = id;
        this.theme = theme;
    }

    public Subject(String theme) {
        this.theme = theme;
    }

    public Subject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
