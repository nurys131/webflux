package tt.example.task.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Task {

    @Id
    String id;
    String name;
    String description;
    boolean completed = false;
//    @CreatedDate
//    private LocalDateTime createdTime;
}
