package ro.capac.server.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

import ro.capac.server.entity.Category;
import ro.capac.server.entity.Event;

@RepositoryRestResource(collectionResourceRel = "categories", path = "category")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

}
