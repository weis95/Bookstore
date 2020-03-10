package demo.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import demo.bookstore.domain.Book;
import demo.bookstore.domain.BookRepository;
import demo.bookstore.domain.Category;
import demo.bookstore.domain.CategoryRepository;
import demo.bookstore.domain.User;
import demo.bookstore.domain.UserRepository;



@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("cat1"));
			crepository.save(new Category("cat2"));
			crepository.save(new Category("cat3"));
			
			brepository.save(new Book("Firstbook", "Johnson", "1995", "9123912391", "15USD", crepository.findByName("cat1").get(0)));
			brepository.save(new Book("Secondbook", "Johny", "1985", "324324234234", "25USD", crepository.findByName("cat2").get(0)));
			brepository.save(new Book("Thirdbook", "Johnatan", "2005", "3213123134", "35USD", crepository.findByName("cat3").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	

}
