import java.util.Random;
import java.util.Scanner;

public class randomNumber {
public static void main(String[] args){
Scanner scan = new Scanner(System.in);
Random rand = new Random();
int RandomNumber = rand.nextInt(101);

System.out.println("Guess a random number");
int GuessedValue = scan.nextInt();
if(GuessedValue < RandomNumber){
    System.out.println("Your Guess is less than the number generated");
    GuessedValue = scan.nextInt();
}
if(GuessedValue > RandomNumber){
    System.out.println("Your Guess is Greater than the number generated");
    GuessedValue = scan.nextInt();
}
if(GuessedValue == RandomNumber){
    System.out.println("Your Guessed the right number");
    
}


    }
}
 
