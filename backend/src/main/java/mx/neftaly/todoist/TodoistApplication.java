package mx.neftaly.todoist;

import mx.neftaly.todoist.model.TodoSet;
import mx.neftaly.todoist.repository.TodoSetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class TodoistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoistApplication.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner demo(TodoSetRepository repository) {
		return (args) -> {
			TodoSet list = new TodoSet();
			list.setName("PRUEBA");
			list.setDescription("PRUEBA DE DESCRIPCION");
			repository.save(list);


			List<TodoSet> result = repository.findAll();
			System.out.println(result.size());
		};
	}
}
