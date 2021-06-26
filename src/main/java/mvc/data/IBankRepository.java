package mvc.data;

import mvc.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankRepository extends MongoRepository<Account, Integer>{
    Account getAccountByAccountNumber(Integer accountNumber);



}
