package RockPaperAndScissors;

public abstract class Player {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTocken() {
        return tocken;
    }

    public void setTocken(String tocken) {
        this.tocken = tocken;
    }

    private String tocken;
    private int score;

    public Player(String name, String tocken) {
        this.name = name;
        this.tocken = tocken;
        this.score = 0;
    }

    public void incrementScore(){
        this.score ++;
    }

}
