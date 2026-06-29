package bank_app.service;

import bank_app.model.User;

public class TransactionServiceImpl implements TransactionService {


    public TransactionServiceImpl() {
    }

    @Override
    public void deposit(User user, Double mountDeposit) {
        if(mountDeposit > 0){
            user.setCapital(user.getCapital()+ mountDeposit);
        }else{
            System.out.println("No puede haber un monto negativo");
        }
    }

    @Override
    public void withdraw(User user, Double mountWithdraw) {
        if (mountWithdraw <= 0) {
            System.out.println("Monto inválido");
        } else if (mountWithdraw > user.getCapital()) {
            System.out.println("Fondos insuficientes");
        } else {
            user.setCapital(user.getCapital() - mountWithdraw);
        }
    }

    @Override
    public void viewCapital(User user) {
        System.out.println(user.getCapital());
    }
}
