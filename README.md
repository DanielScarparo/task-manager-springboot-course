Markdown# Task Manager Spring Boot Course

[![Java Version](https://img.shields.io/badge/Java-17%20%2F%2021-orange?style=for-the-badge&logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](https://opensource.org/licenses/MIT)

**Gerenciador de Tarefas** — Uma API REST robusta desenvolvida com **Java** e **Spring Boot**, projetada como um sistema prático de gerenciamento de tarefas para portfólio e demonstração de competências em arquitetura web e persistência de dados.

---

## 🚀 Status do Projeto

⚡ **Concluído & Pronto para demonstração**

---

## 🛠️ Tecnologias Utilizadas

O projeto foi construído utilizando as melhores práticas de desenvolvimento no ecossistema Spring:

* **Linguagem:** Java (Compatível com versões 17 e 21)
* **Framework Core:** Spring Boot 3.x
* **Persistência de Dados:** Spring Data JPA & Hibernate
* **Bancos de Dados:** * **H2 Database:** Banco em memória otimizado para o ambiente de desenvolvimento e testes rápidos.
    * **PostgreSQL:** Banco de dados relacional robusto configurado para o ambiente de produção.
* **Gerenciador de Dependências:** Maven
* **Produtividade:** Lombok (Redução de código boilerplate)
* **Validação:** Jakarta Validation (`@Valid`) para consistência dos dados de entrada.

---

## 📋 Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:

* **Java Development Kit (JDK):** Versão 17 ou superior.
* **Maven:** Versão 3.6 ou superior (opcional, caso prefira usar o `mvnw` incluso).
* **Docker & Docker Compose:** (Opcional) Caso deseje rodar a infraestrutura de produção localmente.

---

## ⚙️ Instalação, Build e Execução

### 1. Clonar o repositório
```bash
git clone [https://github.com/DanielScarparo/task-manager-springboot-course.git](https://github.com/DanielScarparo/task-manager-springboot-course.git)
cd task-manager-springboot-course
2. Compilar e gerar o artefato (Build)Use o Maven para limpar builds antigos e empacotar a aplicação em um arquivo .jar:Bashmvn clean package
3. Executando a aplicaçãoOpção A: Via Plugin do Spring Boot (Ideal para desenvolvimento)Bashmvn spring-boot:run
Opção B: Executando o arquivo JAR geradoBashjava -jar target/*.jar
A aplicação iniciará por padrão na porta 8080. Acesse http://localhost:8080.🛣️ Endpoints da APIAbaixo estão listados os endpoints principais da aplicação. Você pode testá-los utilizando ferramentas como Postman, Insomnia ou via terminal usando curl.MétodoEndpointDescriçãoGET/taskLista todas as tarefas cadastradasGET/task/{id}Busca os detalhes de uma tarefa específica por IDPOST/taskCria uma nova tarefaPUT/task/{id}Atualiza os dados de uma tarefa existenteDELETE/task/{id}Remove uma tarefa do sistemaGET/task/status/{completed}Filtra tarefas pelo status (true ou false)📝 Exemplo de Payload (POST /task)Request Body (JSON):JSON{
  "title": "Comprar mantimentos",
  "description": "Leite, pão, ovos e café",
  "completed": false,
  "dueDate": "2026-08-20"
}
Exemplo de requisição via curl:Bashcurl -X POST http://localhost:8080/task \
  -H "Content-Type: application/json" \
  -d '{"title": "Comprar mantimentos", "description": "Leite, pão, ovos", "completed": false, "dueDate": "2026-08-20"}'
🗂️ Estrutura do ProjetoPlaintexttask-manager-springboot-course/
│
├── src/
│   ├── main/
│   │   ├── java/         # Código-fonte da aplicação (Controllers, Services, Repositories, DTOs)
│   │   └── resources/    # Configurações do projeto (application.properties, SQL scripts)
│   └── test/             # Testes unitários e de integração
│
├── Dockerfile            # Instruções para containerização da aplicação
├── pom.xml               # Gerenciamento de dependências e plugins do Maven
└── README.md             # Documentação do projeto
🧪 Testes AutomatizadosO projeto conta com suítes de testes para garantir a estabilidade das regras de negócio. Para executar todos os testes estruturados, utilize o comando:Bashmvn test
🌐 Configuração de Banco de Dados (Ambientes)Desenvolvimento (Padrão): O projeto está configurado para subir usando o banco H2. O console do H2 pode ser acessado em http://localhost:8080/h2-console (verifique as credenciais no arquivo application.properties).Produção: Para alternar para o banco de dados PostgreSQL, você pode injetar as seguintes variáveis de ambiente na execução:SPRING_DATASOURCE_URL: URL de conexão do banco (ex: jdbc:postgresql://localhost:5432/taskdb)SPRING_DATASOURCE_USERNAME: Usuário do bancoSPRING_DATASOURCE_PASSWORD: Senha do banco🤝 ContribuiçãoContribuições são sempre bem-vindas! Siga os passos abaixo para colaborar:Faça um Fork do projeto.Crie uma branch para sua funcionalidade ou correção: git checkout -b feature/nova-funcionalidade ou git checkout -b fix/correcao-bug.Certifique-se de que todos os testes estão passando executando mvn test.Faça o Commit de suas alterações com mensagens claras e concisas.Envie um Push para a sua branch: git push origin feature/nova-funcionalidade.Abra um Pull Request detalhando as alterações propostas.📄 LicençaEste projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.👤 AutorDesenvolvido por Daniel Scarparo 👉 Conecte-se comigo no GitHub ou verifique meu portfólio de projetos!
