package RockPaperAndScissors;

import java.time.LocalDate;
import java.util.List;

public class History {
    private LocalDate date;
    private List<Player> players;
    private String result;

    public History(LocalDate date, List<Player> players) {
        this.date = date;
        this.players = players;
    }

    public History() {

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
