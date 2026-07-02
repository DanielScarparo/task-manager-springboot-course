package dio.taskmaneger.application;

import dio.taskmaneger.application.output.TaskOutput;
import dio.taskmaneger.domain.TaskId;
import dio.taskmaneger.domain.TaskNotFoundException;
import dio.taskmaneger.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id) {
        return repository.findById(id).map(TaskOutput::from).orElseThrow(() -> new TaskNotFoundException(id));
    }
}
