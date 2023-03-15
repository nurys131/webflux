package tt.example.client.client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WebClientApp {

    Flux<Task> getAllTasks();
    Mono<Task> getTaskById(String id);
    Mono<Task> addTask(Task task);
    Mono<Void> deleteTask(String id);
}
