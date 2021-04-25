package controller;

import entity.Products;
import entity.Users;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Shop {
    private ArrayList<Products> products = new ArrayList<Products>();
    private ArrayList<Users> users = new ArrayList<Users>();
    Scanner scanner = new Scanner(System.in);


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
        System.out.println("\nAdd new product");

        Products products = new Products();
        System.out.print("Enter product name: ");
        products.productName=scanner.nextLine();
        System.out.print("Enter product price: ");
        products.price=Double.parseDouble(scanner.nextLine());
        System.out.print("Enter amount: ");
        products.amount=Integer.parseInt(scanner.nextLine());
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
        System.out.println("\nAdd new user");

        Users users = new Users();
        System.out.print("Enter name: ");
        users.name=scanner.nextLine();
        System.out.print("Enter surname: ");
        users.surname=scanner.nextLine();
        System.out.print("Enter balance: ");
        users.balance=Double.parseDouble(scanner.nextLine());
        //users.b = UUID.randomUUID();

        String message = addUser(users);
        System.out.println(message);
    }

    private String addUser(Users users) {
        this.users.add(users);
        return users.name+" "+users.surname+" added successfully.";
    }


    public void buyProduct() {
        System.out.println("\nAdd necessary information.");

        System.out.print("User: ");
        String buyer = scanner.nextLine();
        System.out.print("Product: ");
        String buyProduct=scanner.nextLine();
        System.out.print("Amount: ");
        Integer buyAmount=Integer.parseInt(scanner.nextLine());
        System.out.println(buyer+" wants to buy "+buyAmount+" "+buyProduct);

        Products productToSell = findProductToSell(buyProduct);
        Users foundBuyer = findBuyer(buyer);

        if (foundBuyer==null) {
            System.out.println("User not found");
        } else if (productToSell == null){
            System.out.println("Product not found");
        } else if (productToSell.amount<buyAmount){
            System.out.println("Not enough items");
        } else {
            double totalCost = buyAmount*productToSell.price;
            double buyerNewBalance = foundBuyer.balance-totalCost;
            int productNewAmount = productToSell.amount-buyAmount;
            if (totalCost>foundBuyer.balance){
                System.out.println("Not enough balance");
            } else {
                foundBuyer.balance=buyerNewBalance;
                productToSell.amount=productNewAmount;
                System.out.println(buyer+" bought "+buyAmount+" "+buyProduct+" for "+totalCost+"EUR");
            }
        }
    }


    private Products findProductToSell(String buyProduct) {
        for (Products foundProduct:this.products) {
            if (foundProduct.productName.equalsIgnoreCase(buyProduct)) {
                return foundProduct;
            }
        }
        return null;
    }

    private Users findBuyer(String buyer) {
        for (Users foundBuyer:this.users){
            if (foundBuyer.name.equalsIgnoreCase(buyer)){
                return foundBuyer;
            }
        }
        return null;
    }

    public void existingUsers () {
        Users defaultUser = new Users();
        defaultUser.name="Admin";
        defaultUser.surname="Admin";
        defaultUser.balance=100;
        //users.add(defaultUser);
        this.addUser(defaultUser);
        }

}
