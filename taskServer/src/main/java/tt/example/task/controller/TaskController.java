package tt.example.task.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tt.example.task.model.Task;
import tt.example.task.repository.TaskRepository;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskRepository taskRepository;

    @GetMapping(value = "/{id}")
    public Mono<Task> getTaskById(@PathVariable String id) {
        return taskRepository.findById(id);
    }

    @GetMapping
            (produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public Mono<Task> addTask(@RequestBody Task task) {
        return taskRepository.insert(task);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteTask(@PathVariable String id) {
        return taskRepository.deleteById(id);
    }

}
