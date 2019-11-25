package mx.neftaly.todoist.services;

import mx.neftaly.todoist.model.TodoSet;
import mx.neftaly.todoist.params.TodoSetParams;
import mx.neftaly.todoist.repository.TodoSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoSetService {

    private final TodoSetRepository todoSetRepository;

    public TodoSetService(TodoSetRepository todoSetRepository) {
        this.todoSetRepository = todoSetRepository;
    }

    public List showAll() {
        return todoSetRepository.findAll();
    }

    public Optional<TodoSet> find(long id) {
        return Optional.of(todoSetRepository.getOne(id));
    }

    public Optional<TodoSet> create(TodoSetParams todoSet) {
        return Optional.of(null);
    }
}
