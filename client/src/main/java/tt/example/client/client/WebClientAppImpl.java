package tt.example.client.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class WebClientAppImpl implements WebClientApp {

    private final WebClient webClient;
    private final String BASE_URL = "/api/tasks";

    @Override
    @Bean
    public Flux<Task> getAllTasks() {
        Flux<Task> taskFlux = webClient.get()
                .uri(BASE_URL)
                .retrieve()
                .bodyToFlux(Task.class).delayElements(Duration.ofSeconds(1));
        taskFlux.subscribe(System.out::println);
        return taskFlux;
    }

    @Override
    public Mono<Task> getTaskById(String id) {
        return webClient.get()
                .uri(BASE_URL + "/" + id)
                .retrieve()
                .bodyToMono(Task.class);
    }

    @Override
    @Bean
    public Mono<Task> addTask(Task task) {
        task = new Task("TaskAAAAAAAAAAAAAAAAAAAAAAAA", "abc", "???", false);
        Mono<Task> taskMono = webClient.post()
                .uri(BASE_URL)
                .body(Mono.just(task), Task.class)
                .retrieve()
                .bodyToMono(Task.class);
//        taskMono.subscribe(System.out::println);
        return taskMono;
    }

    @Override
    public Mono<Void> deleteTask(String id) {
        return webClient.delete()
                .uri(BASE_URL + "/" + id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}