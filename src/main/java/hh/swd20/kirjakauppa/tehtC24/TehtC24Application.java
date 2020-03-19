package hh.swd20.kirjakauppa.tehtC24;

import hh.swd20.kirjakauppa.tehtC24.domain.*;
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
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {

			// Create users: admin/admin user/user
			userRepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
			userRepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));

			log.info("Save a couple of books and categories...");

			categoryRepository.save(new Category("Literature"));
			categoryRepository.save(new Category("Culture"));
			categoryRepository.save(new Category("Sci-fi"));
			categoryRepository.save(new Category("Horror"));
			categoryRepository.save(new Category("Comedy"));

			for (Category cat : categoryRepository.findAll()) {
				log.info(cat.toString());
			}


			bookRepository.save(new Book("Tesla", "Matts Johansson", categoryRepository.findByName("Horror").get(0),"1994", "2100-2345-113", 54.50));
			bookRepository.save(new Book("Saving Private Ryan", "Lord Hansel",  categoryRepository.findByName("Literature").get(0), "1999", "2833-2345-112",69.50));
			bookRepository.save(new Book("How to code", "Henri Väisänen", categoryRepository.findByName("Sci-fi").get(0), "2020", "1010-1010-101", 199.50));
			log.info("Fetch all books and their information...");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}