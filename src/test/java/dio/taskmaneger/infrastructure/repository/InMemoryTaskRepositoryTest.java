package dio.taskmaneger.infrastructure.repository;

import dio.taskmaneger.domain.*;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest {
    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }
}