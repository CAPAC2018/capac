package ro.capac.server.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

import ro.capac.server.entity.Event;

@RepositoryRestResource(collectionResourceRel = "events", path = "events")
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    List<Event> findEventsByOwnerId(Long ownerId, Pageable pageable);

    List<Event> findEventsByCategoryIgnoreCase(String category, Pageable pageable);

}
