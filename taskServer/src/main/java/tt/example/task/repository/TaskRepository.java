package tt.example.task.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import tt.example.task.model.Task;

@Repository
public interface TaskRepository extends ReactiveMongoRepository<Task, String> {
}
