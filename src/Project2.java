import java.util.Random;
import java.util.Scanner;

public class Project2
{
    private Scanner scan;
    private String name;
    private Random rand;

    public static void main(String[] args) {
        new Project2(new Scanner(System.in)).run();
    }
    public Project2(Scanner s)
    {
        scan = s;
        name = "";
        rand = new Random();
    }
    public int run()
    {
        System.out.print("what is your name: ");
        name = scan.nextLine();
        System.out.println("well, " + name + " guess the number between 1 and 20.");
        boolean again = false;
        do
        {
            int num = rand.nextInt(20)+1;
            int tries = 6;
            int guess = -1;
            do
            {
                do
                {
                    guess = userInput();
                }while (guess == -1);

                if(guess > num)
                {
                    System.out.println("too high");
                }
                if(guess < num)
                {
                    System.out.println("too low");
                }
                if(guess == num)
                {
                    tries = 0;
                }
                tries--;
            }while (tries > 0);
            if(tries == -1)
            {
                System.out.println("you win");
            }
            else
            {
                System.out.println("you lose");
            }
            System.out.println("go agin");
            again = scan.nextLine().charAt(0) == 'y';
        }while (again);
        return 0;
    }
    public int userInput()
    {
        int choice;
        try
        {
            choice = Integer.valueOf(scan.nextLine());
        }
        catch (NumberFormatException e)
        {
            System.out.println("invalid number");
            choice = -1;
        }
        System.out.println(choice);
        return choice;
    }
}
