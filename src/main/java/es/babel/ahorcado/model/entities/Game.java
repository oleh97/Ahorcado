package es.babel.ahorcado.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Word word;
    private String guessWord;
    private int tries;
    private boolean lost;

    public Game(Word word, String guessWord, int tries, boolean lost) {
        this.word = word;
        this.guessWord = guessWord;
        this.tries = tries;
        this.lost = lost;
    }

    public Game() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public String getGuessWord() {
        return guessWord;
    }

    public void setGuessWord(String guessWord) {
        this.guessWord = guessWord;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public void replaceGuessWord(String letter) {
        char[] array = this.word.getWord().toCharArray();
        char[] guessWord = this.guessWord.toCharArray();
        char l =  letter.toCharArray()[0];
        for(int i = 0; i<array.length; i++) {
            if(array[i] == l) {
                guessWord[i] = l;
            }
        }
        String s = new String(guessWord);
        this.guessWord = s;
    }

    public int checkLetter(String letter) {
        return this.word.getWord().indexOf(letter);
    }

    public int checkGuessWordLetter(String letter) {
        return this.guessWord.indexOf(letter);
    }

}
