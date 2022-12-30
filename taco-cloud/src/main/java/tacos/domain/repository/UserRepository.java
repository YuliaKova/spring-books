package tacos.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.domain.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findByUsername(String username);
}
