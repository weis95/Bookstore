package demo.TaskManager.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//Repository for Category
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);
    
}