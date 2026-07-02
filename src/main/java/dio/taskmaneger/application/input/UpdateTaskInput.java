package dio.taskmaneger.application.input;

import dio.taskmaneger.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskInput(Optional<String> title, Optional<String> description, Optional<TaskStatus> status) {
}
