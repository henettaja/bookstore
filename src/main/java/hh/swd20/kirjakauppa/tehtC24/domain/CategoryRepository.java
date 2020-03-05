package hh.swd20.kirjakauppa.tehtC24.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    public List<Category> findByName (String name);

}
