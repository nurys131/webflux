package tt.example.client.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Task {
    private String id;
    private String name;
    private String description;
    private boolean completed = false;
}
