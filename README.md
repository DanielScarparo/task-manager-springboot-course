# ✅ Task Manager API (Clean Architecture)

[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![Gradle](https://img.shields.io/badge/Gradle-9.5-02303A?style=for-the-badge&logo=gradle)](https://gradle.org/)
[![Spring REST Docs](https://img.shields.io/badge/REST%20Docs-Test--Driven%20Docs-6DB33F?style=for-the-badge&logo=spring)](https://spring.io/projects/spring-restdocs)

API RESTful para gerenciamento de tarefas desenvolvida com **Spring Boot**. O grande diferencial deste projeto é a aplicação rigorosa de conceitos de **Clean Architecture (Arquitetura Limpa)** e **Domain-Driven Design (DDD)**, garantindo um código altamente testável, manutenível e independente de frameworks de infraestrutura.

---

## 🏗️ Destaques de Arquitetura e Engenharia

Este projeto não é apenas um CRUD padrão; ele demonstra padrões avançados de design de software:

*   **Clean Architecture (Ports and Adapters):** Separação estrita entre `domain` (regras de negócio puras), `application` (casos de uso) e `infrastructure` (controladores HTTP, repositórios).
*   **Use Cases (Casos de Uso):** Lógica de orquestração isolada em classes de propósito único (Ex: `CreateTaskUseCase`, `DeleteTaskUseCase`), seguindo o princípio da Responsabilidade Única (SRP) do SOLID.
*   **Inversão de Dependência:** O domínio define a interface `TaskRepository`, que é implementada pela infraestrutura (`InMemoryTaskRepository`), permitindo trocar o banco de dados futuramente sem alterar as regras de negócio.
*   **Test-Driven Documentation:** Utilização do **Spring REST Docs** acoplado ao MockMvc para gerar documentação da API automaticamente a partir da execução dos testes de integração, garantindo que a documentação nunca fique defasada.
*   **Tratamento Global de Erros:** Uso de `@RestControllerAdvice` para capturar e padronizar exceções de negócio (`TaskNotFoundException`) e erros de validação (`MethodArgumentNotValidException`).

---

## 🛠️ Tecnologias Utilizadas

*   **Linguagem:** Java (Records, Optional, Streams API)
*   **Framework Core:** Spring Boot
*   **Build e Dependências:** Gradle (Wrapper incluso)
*   **Testes:** JUnit 5, Spring Boot Test, MockMvc, JsonPath
*   **Documentação:** Spring REST Docs (Asciidoctor)
*   **Validação:** Jakarta Validation (`@Valid`, `@NotBlank`, `@Size`)

---

## 🗂️ Estrutura de Diretórios (Clean Architecture)

```text
src/main/java/dio/taskmaneger/
│
├── domain/            # Core do negócio: Entidades (Task), Value Objects (TaskId) e Interfaces. Zero dependências do Spring.
├── application/       # Regras da aplicação: Use Cases, Inputs (Records) e Outputs (Records).
└── infrastructure/    # Adaptadores externos:
    ├── http/          # Controllers REST (TaskController), Requests, Responses e Exception Handler.
    └── repository/    # Implementação de persistência (InMemoryTaskRepository).
````
🛣️ Endpoints da APIA API responde no path /tasks.MétodoEndpointDescriçãoGET/tasksLista todas as tarefasGET/tasks/{id}Busca uma tarefa específica por UUIDPOST/tasksCria uma nova tarefaPATCH/tasks/{id}Atualiza parcialmente uma tarefa (Ex: alterar status)DELETE/tasks/{id}Remove uma tarefa do sistema (Retorna 204 No Content)

📝 Exemplo de Payload
````
(POST /tasks)JSON{
  "title": "Aprender Spring RestDocs",
  "description": "Ler o guia oficial do Spring e implementar testes"
}
````
⚙️ Como Executar o ProjetoVocê não precisa ter o Gradle instalado na sua máquina,
pois o projeto inclui o Gradle Wrapper.
1. Clonar o repositórioBashgit
````
clone [https://github.com/DanielScarparo/task-manager-springboot-course.git](https://github.com/DanielScarparo/task-manager-springboot-course.git)
cd task-manager-springboot-course
````
2. Executar a aplicaçãoNo
Linux/Mac:
````
./gradlew bootRun
````
No Windows:
````
DOSgradlew.bat bootRun
````
A API estará disponível em http://localhost:8080. (Como utiliza persistência em memória, os dados são reiniciados a cada execução, ideal para testes rápidos).

3. Executar os Testes e Gerar Documentação
````
./gradlew test
````
Este comando executa a suíte de testes unitários e de integração e aciona o Spring REST Docs para gerar os snippets de documentação da API.
🤝 Como ContribuirFaça um Fork do projeto.
Crie uma branch para sua funcionalidade:
git checkout -b feature/implementar-banco-postgres.
Commit suas alterações (incluindo testes): git commit -m 'feat: adiciona persistencia com spring data jpa'
Faça o push para a branch: git push origin feature/implementar-banco-postgres.Abra um Pull Request.
👤 AutorDaniel Alves Scarparo SilvaDesenvolvedor focado em Arquitetura de Software e boas práticas.
