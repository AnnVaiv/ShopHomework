package controller;

import java.util.Scanner;

public class Menu {


    public void showMenu() {
        Shop shop = new Shop();
        shop.existingUsers();
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println("Please choose activity:\n");
            System.out.println("1. See all available products");
            System.out.println("2. Add product");
            System.out.println("3. See all users");
            System.out.println("4. Add user");
            System.out.println("5. Buy product");

            System.out.println("Enter \"Q\" to end program.");

            System.out.print("Type here: ");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "q":
                    System.out.println("Exiting application.");
                    break;
                case "1":
                    //clearScreen();
                    shop.viewAllProducts();
                    System.out.println("\nPres Enter to continue.");
                    scanner.nextLine();
                    break;
                case "2":
                    shop.addNewProduct();
                    System.out.println("\nPres Enter to continue.");
                    scanner.nextLine();
                    break;
                case "3":
                    shop.viewAllUsers();
                    System.out.println("\nPres Enter to continue.");
                    scanner.nextLine();
                    break;
                case "4":
                    shop.addNewUser();
                    System.out.println("\nPres Enter to continue.");
                    scanner.nextLine();
                    break;
                case "5":
                    shop.buyProduct();
                    System.out.println("\nPres Enter to continue.");
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Try again.\n");
                    break;

            }
        }

        while (!userInput.equalsIgnoreCase("q"));
    }
    /*public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();*/



}