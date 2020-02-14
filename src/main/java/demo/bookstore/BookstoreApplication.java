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



@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("cat1"));
			crepository.save(new Category("cat2"));
			crepository.save(new Category("cat3"));
			
			brepository.save(new Book("Firstbook", "Johnson", "1995", "9123912391", "15USD", crepository.findByName("cat1").get(0)));
			brepository.save(new Book("Secondbook", "Johny", "1985", "324324234234", "25USD", crepository.findByName("cat2").get(0)));
			brepository.save(new Book("Thirdbook", "Johnatan", "2005", "3213123134", "35USD", crepository.findByName("cat3").get(0)));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	

}
