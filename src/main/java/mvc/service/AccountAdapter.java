package mvc.service;

import mvc.domain.Account;

public class AccountAdapter {
    public static Account getAccount(AccountDTO accountDTO){
        Account account = new Account();
        if(accountDTO != null){
            account = new Account(accountDTO.getAccountNumber(), accountDTO.getAccountHolder());
            account.setBalance(accountDTO.getBalance());
            account.setTransacctions(TransacctionsAdapter.adapt2Transacction(accountDTO.getTransacctions()));
        }
        return account;
    }

    public static AccountDTO getAccountDTO(Account account){
        AccountDTO accountDTO = new AccountDTO();
        if(account != null){
            accountDTO = new AccountDTO(account.getAccountNumber(), account.getAccountHolder());
            accountDTO.setBalance(account.getBalance());
            accountDTO.setTransacctions(TransacctionsAdapter.adapt2TransacctionDTO(account.getTransacctions()));
        }
        return accountDTO;
    }
}
