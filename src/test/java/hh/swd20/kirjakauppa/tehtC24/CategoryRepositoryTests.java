package hh.swd20.kirjakauppa.tehtC24;

import hh.swd20.kirjakauppa.tehtC24.domain.Category;
import hh.swd20.kirjakauppa.tehtC24.domain.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByCategoryNameShouldReturnCategory() {
        List<Category> categories = categoryRepository.findByName("Comedy");

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Comedy");
    }

    @Test
    public void createNewCategory() {
        List<Category> categories = new ArrayList<>();
        Category category = new Category("Nonfiction");

        categoryRepository.save(category);
        assertThat(categoryRepository.findByName("Nonfiction").get(0)).isEqualTo(category);
    }

    @Test
    public void deleteCategory() {
        Category category = new Category("Nonfiction");

        categoryRepository.save(category);
        assertThat(categoryRepository.findByName("Nonfiction").get(0)).isEqualTo(category);

        categoryRepository.delete(category);
        assertThat(categoryRepository.findByName("Nonfiction")).isEmpty();
    }

}
