package controller;

import entity.Products;
import entity.Users;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Shop {
    private ArrayList<Products> products = new ArrayList<Products>();
    private ArrayList<Users> users = new ArrayList<Users>();


    public void viewAllProducts() {
        //System.out.println("viewAllProducts");
        ArrayList<Products> allProducts = getAllProducts();
        System.out.println("\nAll available products:");
        System.out.println("Product name \t\tPrice \t\t\tAvailable amount \t\t\tID");
        for (Products products : allProducts) {
            System.out.println(products.productName + "\t\t\t\t" + products.price + "\t\t\t\t" + products.amount+"\t\t\t\t" + products.id);
        }
    }

    public ArrayList<Products> getAllProducts() {
        return products;
    }

    public void addNewProduct() {
        //System.out.println("addProduct");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAdd new product");

        Products products = new Products();
        System.out.print("Enter product name: ");
        products.productName=scanner.nextLine();
        System.out.print("Enter product price: ");
        products.price=scanner.nextDouble();
        System.out.print("Enter amount: ");
        products.amount=scanner.nextInt();
        products.id = UUID.randomUUID();

        String message = addProduct(products);
        System.out.println(message);
    }

    private String addProduct(Products products) {
        this.products.add(products);
        return products.productName+" added successfully.";
    }

    public void viewAllUsers() {
        //System.out.println("viewAllUsers");
        ArrayList<Users> allUsers = getAllUsers();
        System.out.println("\nAll registered users:");
        System.out.println("Name \t\t\tSurname \t\t\tAvailable balance");
        for (Users users : users) {
            System.out.println(users.name + "\t\t\t" + users.surname + "\t\t\t" + users.balance);
        }
    }

    private ArrayList<Users> getAllUsers() {
        return users;
    }

    public void addNewUser() {
        //System.out.println("addUser");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAdd new user");

        Users users = new Users();
        System.out.print("Enter name: ");
        users.name=scanner.nextLine();
        System.out.print("Enter surname: ");
        users.surname=scanner.nextLine();
        System.out.print("Enter balance: ");
        users.balance=scanner.nextDouble();
        //users.b = UUID.randomUUID();

        String message = addUser(users);
        System.out.println(message);
    }

    private String addUser(Users users) {
        this.users.add(users);
        return users.name+" "+users.surname+" added successfully.";
    }


    public void buyProduct() {
        System.out.println("Add necessary information.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("User:");
        String buyer = scanner.nextLine();
        System.out.print("Product:");
        String buyProduct=scanner.nextLine();
        System.out.print("Amount:");
        int buyAmount=scanner.nextInt();
        System.out.println(buyer+" wants to buy "+buyAmount+" "+buyProduct);



    }
    public void existingUsers () {
        Users defaultUser = new Users();
        defaultUser.name="Admin";
        defaultUser.surname="Admin";
        defaultUser.balance=100;
        //users.add(defaultUser);
        this.addUser(defaultUser);
        addUser(defaultUser);
        }



}
