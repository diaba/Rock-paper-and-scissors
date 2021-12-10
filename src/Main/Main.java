package Main;

import RockPaperAndScissors.Computer;
import RockPaperAndScissors.Person;

import javax.print.attribute.standard.PagesPerMinute;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static final String PAPER = "paper";
    static final  String ROCK = "rock";
    static final  String SCISSORS = "scissors";
    static final String QUIT = "quit";
    static final String PLAY = "play";
    static final String HISTORY = "history";


    public static void main(String[] args) {

        startMenu();

    }
    public  static void startGame(){
        Person player1 = new Person("Player 1", ROCK);
        Computer player2 = new Computer(randomPick());
        boolean status = true;
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
                    System.out.println("It is a tie");
              }else if (player1.getTocken().equals(ROCK)){
                    if (player2.getTocken().equals(PAPER)){
                        System.out.println(player2.getName() + " won!");
                        player2.incrementScore();
                    }else if (player2.getTocken().equals(SCISSORS)){
                        player1.incrementScore();
                        System.out.println(player1.getName() + " won!");
                    }
                }else if (player1.getTocken().equals(PAPER)){
                    if (player2.getTocken().equals(ROCK)){
                        player1.incrementScore();
                        System.out.println(player1.getName() + " won!");
                    }else if (player2.getTocken().equals(SCISSORS)){
                        player2.incrementScore();
                        System.out.println(player2.getName() + " won!");
                    }
                }else if (player1.getTocken().equals(SCISSORS)){
                    if (player2.getTocken().equals(PAPER)){
                        player1.incrementScore();
                        System.out.println(player1.getName() + " won!");
                    }else if (player2.getTocken().equals(ROCK)){
                        player1.incrementScore();
                        System.out.println(player1.getName() + " won!");
                    }
                }
            }
        }
        startMenu();
    }
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
    public static void startMenu(){
        System.out.println("MAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' to play.");
        System.out.println("2. Type 'history' to view your game history.");
        System.out.println("3. Type 'quit' to stop playing.");

        input = new Scanner(System.in);
        String a  = input.nextLine();
        switch (a.toLowerCase()) {
            case PLAY -> {System.out.println("Play ");startGame();}
            case HISTORY -> startGame();
            case QUIT ->{ System.out.println("quit game");System.exit(0);}
        }
    }
}
