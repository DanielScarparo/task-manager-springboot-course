package dio.taskmaneger.application;

import dio.taskmaneger.domain.TaskId;
import dio.taskmaneger.domain.TaskNotFoundException;
import dio.taskmaneger.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskUseCase {
    private final TaskRepository repository;

    public DeleteTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public void execute(TaskId taskId) {
        if (repository.findById(taskId).isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }

        repository.delete(taskId);
    }
}
