package es.babel.ahorcado.model.entities;

public class ClientGameDTO {
    private int gameId;
    private String guessWord;
    private int tries;
    private boolean lost;

    public ClientGameDTO(String guessWord, int tries, boolean lost, int gameId) {
        this.guessWord = guessWord;
        this.tries = tries;
        this.lost = lost;
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public ClientGameDTO() {
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
}
