package presentation;

import java.util.Scanner;

public class Menu {
  Scanner scanner = new Scanner(System.in);

  public void display() {
    System.out.println("Choose an option");
    System.out.println("0-Exit");
    System.out.println("1-Register an User");
    System.out.println("2-Find a User");
    System.out.println("3- Search Users");
    System.out.println("4- List all users");
    System.out.println("5-Delete a user ");
    System.out.println("6-Alter a User");
  }

  public Integer readOption() {
    return scanner.nextInt();
  }

  public String readString() {
    return scanner.nextLine();
  }
}
