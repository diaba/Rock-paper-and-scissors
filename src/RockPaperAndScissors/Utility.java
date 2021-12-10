//package RockPaperAndScissors;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Utility {
//    private static final List<SuperHero> superHeroes = new ArrayList<>();
//    public static void readFile(String fileName) throws IOException {
//        File file = new File(fileName);
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader(file));
//
//            String currentLine = reader.readLine();
//
//            while (currentLine != null) {
//                SuperHero superhero = new SuperHero();
//                String[] data = currentLine.split(",");
//                superhero.setSuperheroName(data[0]);
//                superhero.setRealName(data[1]);
//                superhero.setPlaceOfBirth(data[2]);
//                superHeroes.add(superhero);
//                currentLine = reader.readLine();
//            }
//        } finally {
//            assert reader != null;
//            reader.close();
//        }
//    }
//
//}
//    public static void writeFile(String fileName, String name, String result) throws IOException {
//        FileWriter writer = new FileWriter(fileName,true);
//        BufferedWriter buffer = new BufferedWriter(writer);
//
//        buffer.write(name);
//        buffer.write(",");
//        buffer.write(result);
//        buffer.newLine();
//        buffer.close();
//
//        System.out.println("Write Success!");
//    }
//    public static void playGame() {
//        // TODO write the code so the user can play the game
//        String play = "";
//
//        Scanner input = new Scanner(System.in);
//        String answer ="";
//        int randomNumber = (int) Math.floor(Math.random()* superHeroes.size() );
//        System.out.println("Enter your name");
//        String name = input.nextLine();
//
//        do {
//            System.out.println("Guess Super Hero Name");
//            answer = input.nextLine();
//            update(answer.equals(superHeroes.get(randomNumber).getSuperheroName()));
//
//            System.out.println("What is my real name?");
//            answer = input.nextLine();
//
//            update(answer.equals(superHeroes.get(randomNumber).getRealName())) ;
//            System.out.println("Where was I born?");
//            answer = input.nextLine();
//            update(answer.equals(superHeroes.get(randomNumber).getPlaceOfBirth())) ;
//
//            System.out.println("Do you want to play again yes(y) or no(n)?");
//            play = input.nextLine();
//        }while (!play.equals("n"));
//
//        String result ="";
//        if(countRight > countWrong){
//            result = "Winner";
//        }else{
//            result = "Looser";
//        }
//        System.out.println(name +" is a "+ result);
//        try {
//            writeFile("src/output.txt", name,result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void update(boolean status){
//        if (status) {
//            countRight++;
//        } else {
//            countWrong++;
//        }
//    }
//    public static void main(String[] args) {
//        try {
//            readFile("src/input.txt");
//        } catch (IOException e) {
//            System.out.println("Error while reading the file: " + e.getMessage());
//        }
//
//        // sanity check
//        for (int i = 0; i < superHeroes.size(); i++) {
//            System.out.println(superHeroes.get(i).getSuperheroName());
//        }
//        System.out.println();
//        playGame();
//    }