package hh.swd20.kirjakauppa.tehtC24;

import static org.assertj.core.api.Assertions.assertThat;

import hh.swd20.kirjakauppa.tehtC24.domain.Category;
import hh.swd20.kirjakauppa.tehtC24.domain.CategoryRepository;
import hh.swd20.kirjakauppa.tehtC24.webcontroller.*;
import org.aspectj.weaver.patterns.ExactTypePattern;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class TehtC24ApplicationTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private BookRestController bookRestController;

	@Autowired
	private CategoryController categoryController;

	@Autowired
	private UserController userController;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Test
	void bookContextLoads() throws Exception {
		assertThat(bookController).isNotNull();
	}

	@Test
	void bookRestContextLoads() throws Exception {
		assertThat(bookRestController).isNotNull();
	}

	@Test
	void categoryContextLoads() throws Exception {
		assertThat(categoryController).isNotNull();
	}

	@Test
	void userContextLoads() throws Exception {
		assertThat(userController).isNotNull();
	}

	@Test
	void userDetailContextLoads() throws Exception {
		assertThat(userDetailsService).isNotNull();
	}

}
