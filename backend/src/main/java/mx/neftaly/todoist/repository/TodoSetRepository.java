package mx.neftaly.todoist.repository;

import mx.neftaly.todoist.model.TodoSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoSetRepository extends JpaRepository<TodoSet, Long> {
}
