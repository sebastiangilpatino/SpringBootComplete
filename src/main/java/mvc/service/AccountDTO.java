package mvc.service;

import mvc.domain.Transacctions;

import java.util.ArrayList;
import java.util.List;

public class AccountDTO {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<TransacctionsDTO> transacctions;

    public AccountDTO(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        balance = 0;
        transacctions = new ArrayList<TransacctionsDTO>();
    }

    public AccountDTO() {
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

    public List<TransacctionsDTO> getTransacctions() {
        return transacctions;
    }

    public void setTransacctions(List<TransacctionsDTO> transacctions) {
        this.transacctions = transacctions;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountNumber=" + accountNumber +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                ", transacctions=" + transacctions +
                '}';
    }
}
