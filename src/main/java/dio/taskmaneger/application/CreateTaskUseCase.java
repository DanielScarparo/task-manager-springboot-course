package dio.taskmaneger.application;

import dio.taskmaneger.application.input.CreateTaskInput;
import dio.taskmaneger.application.output.TaskOutput;
import dio.taskmaneger.domain.Task;
import dio.taskmaneger.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {
    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input) {
        var task = new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutput.from(saved);
    }
}
