package hh.swd20.kirjakauppa.tehtC24;

import hh.swd20.kirjakauppa.tehtC24.domain.Book;
import hh.swd20.kirjakauppa.tehtC24.domain.BookRepository;
import hh.swd20.kirjakauppa.tehtC24.domain.Category;
import hh.swd20.kirjakauppa.tehtC24.domain.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TehtC24Application {
	private static final Logger log = LoggerFactory.getLogger(TehtC24Application.class);

	public static void main(String[] args) {
		SpringApplication.run(TehtC24Application.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("Save a couple of books and categories...");

			categoryRepository.save(new Category("Literature"));
			categoryRepository.save(new Category("Culture"));
			categoryRepository.save(new Category("Sci-fi"));
			categoryRepository.save(new Category("Horror"));
			for (Category cat : categoryRepository.findAll()) {
				log.info(cat.toString());
			}

			/*
			bookRepository.save(new Book("Tesla", "Matts Johansson", categoryRepository.findByName("Horror").get(0),1994, "2100-2345-113", 54.50));
			bookRepository.save(new Book("Saving Private Ryan", "Lord Hansel",  categoryRepository.findByName("Literature").get(0), 1999, "2833-2345-112",69.50));
			bookRepository.save(new Book("How to code", "Henri Väisänen", categoryRepository.findByName("Sci-fi").get(0), 2020, "1010-1010-101", 199.50));
			log.info("Fetch all books and their information...");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}*/
		};
	}
}