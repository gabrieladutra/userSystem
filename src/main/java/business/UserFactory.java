package business;

import business.User;

import java.util.Scanner;

public class UserFactory {
    Scanner scanner = new Scanner(System.in);

    public User fromConsole(){
        System.out.println("Register a user");
        System.out.println("User name:");
        String name = scanner.nextLine();
        System.out.println("User age:");
        Integer age = scanner.nextInt();
        System.out.println("User cpf: \n");
        scanner.skip("\\R");
        String cpf = scanner.nextLine();

        return new User(name, age,cpf);
    }
}
