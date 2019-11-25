package mx.neftaly.todoist.controller;

import mx.neftaly.todoist.model.TodoSet;
import mx.neftaly.todoist.params.TodoSetParams;
import mx.neftaly.todoist.services.TodoSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("todosets")
public class TodoSetsController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final TodoSetService todoSetService;

    public TodoSetsController(TodoSetService todoSetService) {
        this.todoSetService = todoSetService;
    }

    @GetMapping
    public ResponseEntity index() {
        List todoSets = todoSetService.showAll();

        log.info(todoSets.toString());

        if (todoSets.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(todoSets);
    }

    @GetMapping("{id}")
    public ResponseEntity show(@PathVariable long id) {
        Optional<TodoSet> todoSet = todoSetService.find(id);
        if (todoSet.isPresent()) {
            return ResponseEntity.ok(todoSet.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody TodoSetParams todoSet) {
        Optional<TodoSet> created = todoSetService.create(todoSet);
        if (created.isPresent()) {
            return ResponseEntity.created(null).body(created.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity destroy(@PathVariable long id) {

        return ResponseEntity.ok("ok");
    }
}
