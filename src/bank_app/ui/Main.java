package bank_app.ui;

import bank_app.model.User;
import bank_app.service.BankMenu;
import bank_app.service.TransactionService;
import bank_app.service.TransactionServiceImpl;

public class Main {
    public static void main(String[] args) {

        TransactionService transactionService= new TransactionServiceImpl();

        User user = new User("Ricardo Jaimes", 45_000D);

        BankMenu bankMenu = new BankMenu(transactionService, user);
        bankMenu.executeAppBank();

    }
}
