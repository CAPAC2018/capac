package ro.capac.server.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

import ro.capac.server.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findByUserEmailAndPassword(String email, String password);
}
