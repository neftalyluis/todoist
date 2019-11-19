package mx.neftaly.todoist.repository;

import mx.neftaly.todoist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
