package dio.taskmaneger.application;

import dio.taskmaneger.application.input.CreateTaskInput;
import dio.taskmaneger.application.output.TaskOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateTaskUseCaseTest {

    @Autowired
     private CreateTaskUseCase useCase;

    @Test
    void shouldCreateTask() {


        CreateTaskInput input = new CreateTaskInput(
                "Estudar Java",
                Optional.of("Fazer exercícios de JUnit")
        );

        // Act
        TaskOutput output = useCase.execute(input);

        // Assert
        assertNotNull(output);

        assertNotNull(output.id());

        assertEquals(
                "Estudar Java",
                output.title()
        );

        assertEquals(
                Optional.of("Fazer exercícios de JUnit"),
                output.description()
        );

        assertEquals(
                "PENDING",
                output.status()
        );
    }
}