package mx.neftaly.todoist.controller;

import mx.neftaly.todoist.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todosets/{todoSetId}/tasks")
public class TasksController {

    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity showTasks() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity addTask() {
        return ResponseEntity.ok().build();

    }

    @PutMapping("{taskId}/complete")
    public ResponseEntity markAsComplete() {
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("{taskId}")
    public ResponseEntity removeTask() {
        return ResponseEntity.ok().build();
    }
}
