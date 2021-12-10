package Main;

import RockPaperAndScissors.Computer;
import RockPaperAndScissors.History;
import RockPaperAndScissors.Person;
import RockPaperAndScissors.Player;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    static Scanner input = new Scanner(System.in);
    static final String PAPER = "paper";
    static final  String ROCK = "rock";
    static final  String SCISSORS = "scissors";
    static final String QUIT = "quit";
    static final String PLAY = "play";
    static final String HISTORY = "history";

    private static final  List<History> gameScore = new ArrayList<>();
   // private static final List<SuperHero> superHeroes = new ArrayList<>();




    public static void main(String[] args) throws IOException {

        startMenu();

    }

    /**
     * <h1> startGame</h1>
     * <h2>description</h2>
     *  Set up 2 players and check the winner after each round
     *  Save the game to history file
     * @throws IOException
     */
    public  static void startGame() throws IOException {

        Person player1 = new Person("You");
        Computer player2 = new Computer(randomPick());
        List<Player> players = new ArrayList<>() ;
        players.add(player1);
        players.add(player2);
        boolean status = true;
        History history = new History(LocalDate.now(),players );

        int i=0;
        while(status){
            System.out.println("Type 'rock', 'paper' or 'scissors' to play.");
            System.out.println("Type 'quit' to go back to main menu.");
            String answer = input.nextLine();
            if(answer.equalsIgnoreCase(QUIT)){

                status = false;
                startMenu();
            }else if ( (!answer.equalsIgnoreCase(ROCK) ) &&  (!answer.equalsIgnoreCase(PAPER)) &&  (!answer.equalsIgnoreCase(SCISSORS) )){
                System.out.println("Invalid choice");
            }else {
                player1.setTocken(answer);
                player2.setTocken(randomPick());

                System.out.println("Computer choice: "+ player2.getTocken());
                if(player1.getTocken().equals(player2.getTocken())){
                    history.setResult("It's a Tie");
              }else if (player1.getTocken().equals(ROCK)){
                    if (player2.getTocken().equals(PAPER)){
                        history.setResult(player1.getName() +" Lost");
                        System.out.println(player2.getName() + " won!");

                    }else if (player2.getTocken().equals(SCISSORS)){
                        history.setResult(player1.getName() +" Won");
                        System.out.println(player1.getName() + " won!");
                    }
                }else if (player1.getTocken().equals(PAPER)){
                    if (player2.getTocken().equals(ROCK)){
                        history.setResult(player1.getName() +" Won");
                        System.out.println(player1.getName() + " won!");
                    }else if (player2.getTocken().equals(SCISSORS)){
                        history.setResult(player1.getName() +" Lost");
                        System.out.println(player2.getName() + " won!");
                    }
                }else if (player1.getTocken().equals(SCISSORS)){
                    if (player2.getTocken().equals(PAPER)){
                        history.setResult(player1.getName() +" Won");
                        System.out.println(player1.getName() + " won!");
                    }else if (player2.getTocken().equals(ROCK)){
                        history.setResult(player1.getName() +" Won");
                        System.out.println(player1.getName() + " won!");
                    }
                }
            }
            //Save to file
            writeFile("src/RockPaperAndScissors/histoty.txt",history.getPlayers(), history.getDate(), history.getResult());
        }

        startMenu();
    }

    /**
     * <h1>History method</h1>
     * <p>History method displays the history of your game</p>
     * <p>Shows your wins, lost and tie </p>
     * <p>Shows the date</p>
     *  @throws IOException
     */
    public static void history() throws IOException {
        boolean active = true;
        try{
            readFile("src/RockPaperAndScissors/histoty.txt");
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }
        while (active){
            for (int i = 0; i < gameScore.size(); i++) {
            System.out.println(gameScore.get(i).getPlayers().stream().map(x->x.getName()).collect(Collectors.joining(" Vs ")) + "  "+ gameScore.get(i).getDate()
            +" "+ gameScore.get(i).getResult());
        }
        System.out.println();
            System.out.println("Type 'quit' to go back to main menu");
            String key = input.nextLine();
            if (key.equalsIgnoreCase(QUIT)){
                active = false;
            }
        }startMenu();
    }
    /**
     * <h1>random method</h1>
     * <p>randomPick return String ("rock"),("paper") or ("scissors")</p>
     * <p>Call the Math.floor to round the random pick got from Math.random</p>
     */
    public static String randomPick(){

        int ran = (int) Math.floor(Math.random() * 3);
        if( ran == 0){
            return "rock";
        }else if (ran == 1){
            return "paper";
        }else{
            return "scissors";
        }
    }

    /**
     * <h1>Start Menu</h1>
     * <p>This method display a list of option.After input validation it will call the appropriate method</p>
     *
     * <p> 1 play call @startGame method</p>
     * <p> 2 history call {@link #history()}  method</p>
     * <p> 3 quit call System.exit(0) to exit the game</p>
     */

    public static void startMenu() throws IOException {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("MAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' to play.");
        System.out.println("2. Type 'history' to view your game history.");
        System.out.println("3. Type 'quit' to stop playing.");

        input = new Scanner(System.in);
        String a  = input.nextLine();
        switch (a.toLowerCase()) {
            case PLAY -> {System.out.println("Play ");startGame();}
            case HISTORY -> history();
            case QUIT ->{ System.out.println("quit game");System.exit(0);}
        }
    }

    /**
     *
     * @param fileName
     * @throws IOException
     * Read the records from the @fileName
     */

    public static void readFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));

            String currentLine = reader.readLine();

            while (currentLine != null) {
                History history = new History();
                String[] data = currentLine.split(",");
                List<Player> players = new ArrayList<> ();
                players.add(new Person(data[0]) );
                players.add(new Person(data[1]) );

                history.setPlayers(players);
                history.setDate(LocalDate.parse(data[2]));
                history.setResult(data[3]);
                gameScore.add(history);
                currentLine = reader.readLine();
            }
        } finally {
            assert reader != null;
            reader.close();
        }
    }

    /**
     *
     * @param fileName
     * @param players
     * @param date
     * @param result
     * @throws IOException
     */
    public static void writeFile(String fileName, List<Player> players, LocalDate date, String result) throws IOException {
        FileWriter writer = new FileWriter(fileName,true);
        BufferedWriter buffer = new BufferedWriter(writer);
        String playersStr = players.stream().map(x->x.getName()).collect(Collectors.joining(","));
        buffer.write(playersStr);
        buffer.write(",");
        buffer.write(date.toString());
        buffer.write(",");
        buffer.write(result);
        buffer.newLine();
        buffer.close();

        System.out.println("Write Success!");
    }


}
