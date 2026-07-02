package dio.taskmaneger.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

 public abstract class TaskRepositoryTest {
     TaskRepository repository;

     protected abstract TaskRepository createRepository();

    @BeforeEach
    void setUp() {
        this.repository = createRepository();
    }

    @Test
    void deveSalvarUmaTask() {
        Task task = new Task(
                "Estudar JUnit",
                Optional.of("Criar testes da aplicação")
        );

        Task salva = repository.save(task);

        assertNotNull(salva);
        assertEquals(task.getId(), salva.getId());
        assertEquals("Estudar JUnit", salva.getTitle());
        assertEquals(TaskStatus.PENDING, salva.getStatus());
    }

    @Test
    void deveBuscarTaskPorId() {
        Task task = new Task(
                "Estudar Spring",
                Optional.empty()
        );

        repository.save(task);

        Optional<Task> resultado = repository.findById(task.getId());

        assertTrue(resultado.isPresent());
        assertEquals(task.getId(), resultado.get().getId());
        assertEquals(task.getTitle(), resultado.get().getTitle());
    }

    @Test
    void naoDeveEncontrarTaskInexistente() {
        TaskId id = new TaskId();

        Optional<Task> resultado = repository.findById(id);

        assertFalse(resultado.isPresent());
    }

    @Test
    void deveListarTodasAsTasks() {
        Task task1 = new Task(
                "Task 1",
                Optional.empty()
        );

        Task task2 = new Task(
                "Task 2",
                Optional.of("Descrição")
        );

        repository.save(task1);
        repository.save(task2);

        assertEquals(2, repository.findAll().size());
    }

    @Test
    void deveExcluirUmaTask() {
        Task task = new Task(
                "Excluir Task",
                Optional.empty()
        );

        repository.save(task);

        repository.delete(task.getId());

        assertFalse(repository.findById(task.getId()).isPresent());
        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    void excluirTaskInexistenteNaoDeveGerarErro() {
        TaskId id = new TaskId();

        assertDoesNotThrow(() -> repository.delete(id));
    }

}