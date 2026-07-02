package dio.taskmaneger.application;

import dio.taskmaneger.application.input.UpdateTaskInput;
import dio.taskmaneger.application.output.TaskOutput;
import dio.taskmaneger.domain.TaskId;
import dio.taskmaneger.domain.TaskNotFoundException;
import dio.taskmaneger.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id, UpdateTaskInput input) {
        var task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.update(input.title(), input.description(), input.status());
        var updated = repository.save(task);
        return TaskOutput.from(updated);
    }
}
