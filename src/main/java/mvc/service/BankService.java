package mvc.service;

import mvc.data.IBankRepository;
import mvc.domain.Account;
import mvc.domain.Transacctions;
import mvc.integration.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BankService {

    @Autowired
    IBankRepository bankRepository;

    @Autowired
    EmailSender emailSender;

    public void save(AccountDTO accountDto) {
        Account account = AccountAdapter.getAccount(accountDto);
        bankRepository.save(account);
        emailSender.sendEmail(account.getAccountHolder(), "Welcome");
    }

    public AccountDTO getAccount(int accountNumber) {
        return AccountAdapter.getAccountDTO(bankRepository.getAccountByAccountNumber(accountNumber));
    }

    public void delete(AccountDTO accountDTO) {
        Account account = AccountAdapter.getAccount(accountDTO);
        bankRepository.delete(account);
    }

    public List<AccountDTO> findAll() {
        List<Account> accounts = bankRepository.findAll();
        List<AccountDTO> accountsDTO = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            accountsDTO.add(AccountAdapter.getAccountDTO(accounts.get(i)));
        }
        return accountsDTO;
    }

    public void deposit(TransacctionsDTO transacctionsDto) {
        Transacctions transacctions = TransacctionsAdapter.getTransaction(transacctionsDto);
        Account account = bankRepository.getAccountByAccountNumber(transacctions.getAccountNumber());
        account.addTransaction(transacctions);
        account.setBalance(account.getBalance() + transacctions.getAmount());
        bankRepository.save(account);
    }

    public void withdraw(TransacctionsDTO transacctionsDto) {
        Transacctions transacctions = TransacctionsAdapter.getTransaction(transacctionsDto);
        Account account = bankRepository.getAccountByAccountNumber(transacctions.getAccountNumber());
        account.addTransaction(transacctions);
        account.setBalance(account.getBalance() - transacctions.getAmount());
        bankRepository.save(account);
    }
}
