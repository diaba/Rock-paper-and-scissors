package RockPaperAndScissors;

public abstract class Player {
    public Player(String name) {
        this.name = name;
    }



    private String name;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

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

    }


}
