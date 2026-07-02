package dio.taskmaneger.application;

import dio.taskmaneger.application.output.TaskOutput;
import dio.taskmaneger.domain.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTasksUseCase {
    private final TaskRepository repository;

     public GetTasksUseCase(TaskRepository repository) {
         this.repository = repository;
     }

     public List<TaskOutput> execute() {
         return repository.findAll().stream().map(TaskOutput::from).toList();
     }
}
