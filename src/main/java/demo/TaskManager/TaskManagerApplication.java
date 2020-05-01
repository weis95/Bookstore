package demo.TaskManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import demo.TaskManager.domain.Task;
import demo.TaskManager.domain.TaskRepository;
import demo.TaskManager.domain.Category;
import demo.TaskManager.domain.CategoryRepository;
import demo.TaskManager.domain.User;
import demo.TaskManager.domain.UserRepository;



@SpringBootApplication
public class TaskManagerApplication {
	private static final Logger log = LoggerFactory.getLogger(TaskManagerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner taskManagerDemo(TaskRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of tasks");
			crepository.save(new Category("Available"));
			crepository.save(new Category("Under Review"));
			crepository.save(new Category("Done"));
			
			brepository.save(new Task("First Task", "A simple Task", "02/06/2020", "02/05/2020", "Admin", crepository.findByName("Available").get(0)));
			brepository.save(new Task("Second Task", "An advanced Task", "02/06/2020", "01/05/2020", "Admin", crepository.findByName("Under Review").get(0)));
			brepository.save(new Task("Third Task", "Horrible Task", "02/06/2020", "03/05/2020", "Admin", crepository.findByName("Done").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all tasks");
			for (Task task : brepository.findAll()) {
				log.info(task.toString());
			}

		};
	}
	

}
