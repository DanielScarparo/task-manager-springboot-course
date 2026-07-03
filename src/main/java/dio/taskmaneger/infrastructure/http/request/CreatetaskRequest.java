package dio.taskmaneger.infrastructure.http.request;

import dio.taskmaneger.application.input.CreateTaskInput;

import java.util.Optional;

public record CreatetaskRequest(String title, Optional<String> description ){
    public CreateTaskInput toInput() {
        return new CreateTaskInput(title, description);
    }
}
