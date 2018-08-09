package ro.capac.server.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ro.capac.server.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
