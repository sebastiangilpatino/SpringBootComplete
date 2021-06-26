package mvc.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {

    @Id
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<Transacctions> transacctions;

    public Account(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        balance = 0;
        transacctions = new ArrayList<Transacctions>();
    }

    public Account() {
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addTransaction(Transacctions tran) {
        transacctions.add(tran);
    }

    public List<Transacctions> getTransacctions() {
        return transacctions;
    }

    public void setTransacctions(List<Transacctions> transacctions) {
        this.transacctions = transacctions;
    }
}
