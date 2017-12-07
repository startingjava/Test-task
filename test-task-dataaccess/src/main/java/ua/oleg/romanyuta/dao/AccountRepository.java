package ua.oleg.romanyuta.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.oleg.romanyuta.domain.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    public Account findByUsername(String username);
}
