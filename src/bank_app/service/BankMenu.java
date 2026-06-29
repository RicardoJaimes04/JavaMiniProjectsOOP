package bank_app.service;

import bank_app.model.User;

import java.util.Scanner;

public class BankMenu {

    private final User user;
    private final TransactionService transactionService;
    private Scanner scanner;

    public BankMenu(TransactionService transactionService, User user) {
        this.transactionService = transactionService;
        this.user = user;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu(){
        System.out.println("=================================");
        System.out.println("       BANK APPLICATION");
        System.out.println("=================================");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View Balance");
        System.out.println("4. Exit");
        System.out.println("=================================");
        System.out.print("Select an option: ");
    }

    public int selectOption(){
        return scanner.nextInt();
    }

    public Double selectAmount(){
        System.out.println("Ingrese el monto: ");
        return scanner.nextDouble();
    }

    public void handleWithdraw(){
        double amount = selectAmount();
        transactionService.withdraw(this.user,amount);

    }

    public void handleDeposit(){
        double amount = selectAmount();
        transactionService.deposit(this.user,amount);

    }

    public void handleViewBalance(){
        transactionService.viewCapital(user);
    }

    public void executeOption(int option){
        switch (option){
            case 1:
                handleDeposit();
                break;
            case 2:
                handleWithdraw();
                break;
            case 3:
                handleViewBalance();
                break;
            case 4:
                return;
        }
    }


    public void executeAppBank(){
        int option;
        do{
            showMenu();
            option = selectOption();
            executeOption(option);
        } while(option !=4);
    }
}