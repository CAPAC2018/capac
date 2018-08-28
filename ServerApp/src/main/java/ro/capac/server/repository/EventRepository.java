package ro.capac.server.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import ro.capac.server.entity.Event;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    List<Event> findAllByCategory(String category);
}
