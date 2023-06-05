package userLogin;

import java.util.Scanner;

public class UserMain {
    static Scanner scanner = new Scanner(System.in);
    static User loggedInUser = null;

    public static boolean runLogin(LoginSystem loginSystem) {
        boolean manager = false;
        while (loggedInUser == null) {
            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            loggedInUser = loginSystem.login(username, password);

            if (loggedInUser == null) System.out.println("Invalid username or password. Please try again.");
            else{
                System.out.println("Login successful!");
                System.out.println("Welcome, " + loggedInUser.getUsername() + "!");

                if (loggedInUser.getRole() == Role.STAFF) {
                    System.out.println("You have staff privileges.");
                } else if (loggedInUser.getRole() == Role.MANAGER) {
                    System.out.println("You have manager privileges.");
                    manager = true;
                }
            }
        }
        return manager;
    }
}
