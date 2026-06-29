package bank_app.service;

import bank_app.model.User;

public interface TransactionService {

    public void deposit(User user, Double mountDeposit);
    public void withdraw(User user, Double mountWithdraw);
    public void viewCapital(User user);
}
