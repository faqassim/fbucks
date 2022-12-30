import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class fbucks {
    public static void fileOut(int balance, int global) throws FileNotFoundException {

        // parsing a CSV file into Scanner class constructor
        File file = new File("balance.csv");
        Scanner scnr = new Scanner(file);

        // Creating the first line
        String currentLine = scnr.nextLine();
        String[] firstLine = currentLine.split(",");

        currentLine = scnr.nextLine();
        String[] secondLine = currentLine.split(",");

        PrintWriter out = new PrintWriter(file);

        out.println("balance,global");
        out.println(balance + "," + global);
        out.close();
    }

    public static void main(String[] args) throws Exception {
        // parsing a CSV file into Scanner class constructor
        File file = new File("balance.csv");
        Scanner scnr = new Scanner(file);

        // Creating the first line
        String currentLine = scnr.nextLine();
        String[] firstLine = currentLine.split(",");

        currentLine = scnr.nextLine();
        String[] secondLine = currentLine.split(",");
        int balance = Integer.valueOf(secondLine[0]);
        int global = Integer.valueOf(secondLine[1]);

        Scanner sc = new Scanner(System.in);
        System.out.print("Welcome to the fbucks atm Farris!\nWhat would you like to do today?\n[1] Check balance\n[2] Add good habit\n[3] Buy reward\nInput: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Your balance is: " + balance);
        } else if (choice == 2) {
            System.out.print("What did you do today?\n[1] Pray\n[2] Gym\n[3] finished an assignment\n[4] Studied for an hour with no distractions\n[5] Made bed\n[6] Cooked\n[7] Ate three small meals in a a day\nInput: ");
            int good = sc.nextInt();
            if (good == 2) { 
                balance += 3;
                global += 3;
                System.out.println("Good job added 3 points to balance, your new balance is:" + balance);
            } else if (good == 3) { 
                balance += 3;
                global += 3;
                System.out.println("Good job added 3 points to balance, your new balance is:" + balance);
            } else { 
                balance++;
                global++;
                System.out.println("Good job added 1 point to balance, your new balance is: " + balance);
            } 
        } else if (choice == 3) {
            System.out.print("What do you wanna do?\n[1] One anime episode ($1)\n[2] Gaming Session($2)\n[3] Small bag of chips($10)\n[4] Medium bag of chips($15)\n[5] Big bag of chips($20)\n[6] Large fast food order($25)\nInput: ");
            choice = sc.nextInt(); 
            if (choice == 1 && balance >= 1) {
                balance--;
                System.out.println("Enjoy! New balance: " + balance);
            } else if (choice == 2 && balance >= 5) { 
                balance -= 5;
                System.out.println("Enjoy! New balance: " + balance);
            } else if (choice == 3 && balance >= 10) {
                balance -= 10;
                System.out.println("Enjoy! New balance: " + balance);
            }  else if (choice == 4 && balance >= 10) {
                balance -= 15; 
                System.out.println("Enjoy! New balance: " + balance);
            }  else if (choice == 5 && balance >= 10) {
                balance -= 20; 
                System.out.println("Enjoy! New balance: " + balance);
            }  else if (choice == 6 && balance >= 10) {
                balance -= 25; 
                System.out.println("Enjoy! New balance: " + balance);
            } else {
                System.out.println("Insufficient balance!");
            }
        }
        fileOut(balance, global);
    }
}