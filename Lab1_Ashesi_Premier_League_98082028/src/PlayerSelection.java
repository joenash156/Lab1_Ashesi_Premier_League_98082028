// Project: Ashesi Premeir League Simulation
// Author: Joshua Adjei
// Data: Sep 20, 2025


// Neccessary imports
import java.util.Scanner;


public class PlayerSelection {

  public static void main(String[] args) {

    System.out.println(); // Print new line

    // Declaration of neccessary variable that will be needed
    String name;
    int age;
    double height;
    double weight;
    int jerseyNum;
    
    // Using try-with-resources for Scanner to auto close and open the Scanner
    try(Scanner input = new Scanner(System.in)) {
      // Take user's inputs
      System.out.print("Enter Player Name: ");
      name = input.nextLine();

      System.out.print("Enter Player Age: ");
      age = input.nextInt();

      System.out.print("Enter Player Height (in meters): ");
      height = input.nextDouble();

      System.out.print("Enter Player Weight (in pounds): ");
      weight = input.nextDouble();

      System.out.print("Enter Player Jersey Number: ");
      jerseyNum = input.nextInt();

      // Convert Player details where neccessary
      final double POUND = 0.45359237;
      final int METER = 100;

      int heightCm = (int) (height * METER);
      int weightKg = (int) (weight * POUND);

      // Age increment and Jersey number reduction
      // int increasedAge = age;
      // increasedAge ++;
      // int decreasedJerseyNum  = jerseyNum;
      // decreasedJerseyNum --;

      // Player Category
      String category;

      if(age >= 18 && age < 20) {
        category = "Rising Star";
      } else if(age <= 30) {
        category = "Prime Player";
      } else {
        category = "Veteran";
      }    
      
      // Player Position
      String position;

      switch(jerseyNum) {
        case 1 -> { 
          position = "GoalKeeper"; 
          break;
        }
        case 2, 5 -> {
          position = "Defender";
          break;
        }  
        case 6, 8 -> {
          position = "Midfielder";
          break;
        }
        case 7, 11 -> {
          position = "Winger";
          break;
        }
        case 9 -> {
          position = "Striker";
          break;
        }
        case 10 -> {
          position = "Playmaker";
          break;
        }
        default -> {
          position = "Unknown";
          break;
        }
      } 

      // Attacker Jersey Check (Yes / No)
      boolean attacker = (jerseyNum == 7 || jerseyNum == 9 || jerseyNum == 10 || jerseyNum == 11);
      String attackerCheck = attacker ? "Yes" : "No";

      // Player eligibility check
      boolean eligible = (age >= 18 && age <= 35 && weightKg < 90);
      String eligibility = eligible ? "Eligible" : "Not Eligible";

      // Lineup Decision
      String lineupDecision;

      if(category.equals("Prime Player")) {
        if(weightKg < 80) {
          lineupDecision = "Starting Lineup";
        } else {
          lineupDecision = "Bench";
        }
      } else {
        lineupDecision = "Bench";
      }

      // Final Decision (Play / Rest)
      String finalDecision = eligible ? "Play" : "Rest";

      // Player Report
      System.out.println(); // Print new line
      System.out.println("--- Player Report ---");
      System.out.println("======================");
      System.out.println(); // Print a new line

      System.out.printf("Player: %s %n", name);
      System.out.printf("Age: %d (%s) %n", age, category);
      System.out.printf("Height: %dcm %n", heightCm);
      System.out.printf("Weight: %dkg %n", weightKg);
      System.out.printf("Jersey: %d %n", jerseyNum);
      System.out.printf("Position: %s %n", position);
      System.out.printf("Attacker Jersey: %s %n", attackerCheck);
      System.out.printf("Eligibilty: %s %n", eligibility);
      System.out.printf("Lineup Decision: %s %n", lineupDecision);
      System.out.printf("Final Decision: %s %n", finalDecision);

      System.out.println(); // Print a new line
      System.out.println("Thank you!");
      System.out.println();

      

      } // End of try-with-resources block

      

    } // End of main method

  } // End of PlayerSelection class