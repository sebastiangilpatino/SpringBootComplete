package mvc.service;

import java.time.LocalDate;

public class TransacctionsDTO {

    private LocalDate date;


    private double amount;

    private int accountNumber;

    public TransacctionsDTO(LocalDate date, double amount, int accountNumber ) {
        this.date = date;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public TransacctionsDTO() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

}
