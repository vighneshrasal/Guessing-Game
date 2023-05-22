import java.util.Scanner;

//Game class
class Game {
    // Creating attributes
    int random;
    int count = 0;
    boolean state;

    // constructor which will generate a random number
    public Game() {
        double rand = Math.random() * 100;
        random = (int) (rand);
    }

    // userInput will take input from user and pass it on to isCorrect
    public void userInput(int input) {
        isCorrect(input);
    }

    // isCorrect will check the number and respond accordingly
    public void isCorrect(int input) {
        Scanner in = new Scanner(System.in);
        if (input == random) {
            // if number is correct
            state = setCount();
            if (state == false) {
                return;
            }
            System.out.println("You guessed it correct, your number of guesses are: " + getCount());
        } else if (input > random) {
            // if number is greater
            state = setCount();
            if (state == false) {
                return;
            }
            System.out.println("Your guess is greater, try again");
            input = in.nextInt();
            isCorrect(input);
        } else {
            // if number is lower
            state = setCount();
            if (state == false) {
                return;
            }
            System.out.println("Your guess is lower, try again");
            input = in.nextInt();
            isCorrect(input);
        }
    }

    // setCount will increase the count for each guess and checks whether it is
    // greater than 5
    public boolean setCount() {
        count++;
        if (count > 5) {
            System.out.println("You Lost!!");
            return false;
        }
        return true;
    }

    // getCount will return the number of guesses a user makes
    public int getCount() {
        return count;
    }
}

public class guessingGame {
    public static void main(String[] args) {
        // creating object of Game class to call the constructor
        Game player = new Game();

        // Taking input from user and calling userInput method
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter a number to guess from 0 to 100, you must guess it in less than 5 guesses possible guess");
        int input = inp.nextInt();

        player.userInput(input);
    }
}
