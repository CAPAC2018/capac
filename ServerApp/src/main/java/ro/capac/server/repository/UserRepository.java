package ro.capac.server.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

import ro.capac.server.entity.User;

/**
 * Spring DATA based DB repository interface.
 * https://docs.spring.io/spring-data/jpa/docs/2.0.9.RELEASE/reference/html/
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findByUserEmailAndPassword(String email, String password);
    Optional<User> findByUserEmail(String email);
    Optional<User> findByUserName(String userName);
}
