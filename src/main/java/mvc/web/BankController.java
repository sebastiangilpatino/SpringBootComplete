package mvc.web;

import mvc.domain.Account;
import mvc.domain.Transacctions;
import mvc.service.AccountDTO;
import mvc.service.BankService;
import mvc.service.TransacctionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;


@RestController
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/bank")
    public ResponseEntity<?> handlePost(@RequestParam(value = "operation", required = false, defaultValue = "") String operation,
                                        @RequestParam(value = "accountNumber", required = false) int accountNumber,
                                        @RequestParam(value = "amount", required = false) Double amount,
                                        @RequestParam(value = "accountHolder", required = false) String accountHolder) {
        AccountDTO account = new AccountDTO();

        if (operation.equals("")) {
            if (accountNumber != 0 && accountHolder != null) {
                String accountHolderName = accountHolder.substring(1, accountHolder.length() - 1);
                account = new AccountDTO(accountNumber, accountHolderName);
                bankService.save(account);
                return new ResponseEntity<AccountDTO>(account, HttpStatus.OK);
            }
        } else {
            String operationName = operation.substring(1, operation.length() - 1);
            switch (operationName) {
                case "deposit":
                    account = bankService.getAccount(accountNumber);
                    if (account == null) {
                        return new ResponseEntity<CustomErrorType>(new CustomErrorType("AccountNumber # "
                                + accountNumber + " is not available"), HttpStatus.NOT_FOUND);
                    }
                    bankService.deposit(new TransacctionsDTO(LocalDate.now(), amount, accountNumber));
                    return new ResponseEntity<AccountDTO>(account, HttpStatus.OK);

                case "withdraw":
                    account = bankService.getAccount(accountNumber);
                    if (account == null) {
                        return new ResponseEntity<CustomErrorType>(new CustomErrorType("AccountNumber # "
                                + accountNumber + " is not available"), HttpStatus.NOT_FOUND);
                    }
                    bankService.withdraw(new TransacctionsDTO(LocalDate.now(), amount, accountNumber));
                    return new ResponseEntity<AccountDTO>(account, HttpStatus.OK);
            }
        }

        return new ResponseEntity<AccountDTO>(account, HttpStatus.OK);
    }

    @GetMapping("/bank/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable int accountNumber) {
        AccountDTO account = bankService.getAccount(accountNumber);
        if (account == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("AccountNumber # "
                    + accountNumber + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AccountDTO>(account, HttpStatus.OK);
    }

    @DeleteMapping("/bank/{accountNumber}")
    public ResponseEntity<?> removeAccount(@PathVariable int accountNumber) {
        AccountDTO account = bankService.getAccount(accountNumber);
        if (account == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("AccountNumber # "
                    + accountNumber + " is not available"), HttpStatus.NOT_FOUND);
        }
        bankService.delete(account);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
