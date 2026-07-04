package dio.taskmaneger.infrastructure.http.request;

import dio.taskmaneger.application.input.UpdateTaskInput;
import dio.taskmaneger.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskRequest(
        Optional<String> title,
        Optional<String> description,
        Optional<String> status
) {
    public UpdateTaskInput toInput() {
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));
    }
}
