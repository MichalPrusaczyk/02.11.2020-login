package eu.prusaczyk.login.gui;

import eu.prusaczyk.login.database.UsersRepository;
import eu.prusaczyk.login.model.User;

import java.util.List;
import java.util.Scanner;

public class GUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu(){
        System.out.println("1. Login");
        System.out.println("2. Register");

        switch (scanner.nextLine()){
            case "1":
                showLoginScreen();
                showMainMenu();
                break;
            case"2":
                showRegisterScreen();
                showMainMenu();
                break;
            case "3":
                System.exit(0);
            case"9":
                showDatabase();
                showMainMenu();
            default:
                System.out.println("Incorrect choice");
                showMainMenu();
                break;
        }
    }

    private static void showLoginScreen(){
        System.out.println("Please set your login");
        String login = scanner.nextLine();
        System.out.println("Please set your password");
        String pass = scanner.nextLine();

        boolean authenticationResult = UsersRepository.getInstance().authenticate(login, pass);

        if (authenticationResult) {
            System.out.println("Logged in");
        } else {
            System.out.println("Incorrect password or login");
        }
    }

    private static void showRegisterScreen(){
        System.out.println("Set login");
        String login = scanner.nextLine();
        System.out.println("Set password");
        String pass = scanner.nextLine();

        boolean registerResult = UsersRepository.getInstance().register(login, pass);

        if(registerResult){
            System.out.println("Registration correct");
        }else {
            System.out.println("Invalid login");
        }
    }
    private static void showDatabase(){
        List<User> userList = UsersRepository.getInstance().getUserList();
        for(User user : userList){
            System.out.println(userList);
        }

    }
}
