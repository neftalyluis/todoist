package mx.neftaly.todoist.controller;

import mx.neftaly.todoist.model.TodoSet;
import mx.neftaly.todoist.repository.TodoSetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todosets")
public class TodoSetsController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final TodoSetRepository todoSetRepository;

    public TodoSetsController(TodoSetRepository todoSetRepository) {
        this.todoSetRepository = todoSetRepository;
    }

    @GetMapping
    public List<TodoSet> index() {
        return todoSetRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @GetMapping
    public TodoSet show(@PathVariable long id) {
        return todoSetRepository.getOne(id);
    }

    @PostMapping
    public TodoSet create(TodoSet todoSet) {
        return todoSetRepository.save(todoSet);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable long id) {
        todoSetRepository.deleteById(id);
    }
}
