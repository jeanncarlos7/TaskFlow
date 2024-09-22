# TaskFlow - API de Gerenciamento de Tarefas

TaskFlow é uma API RESTful desenvolvida em Java com Spring Boot para gerenciamento de tarefas. Ela oferece funcionalidades CRUD (Create, Read, Update, Delete) para manipular tarefas e inclui recursos como paginação, busca, segurança com JWT, e migrações de banco de dados usando Flyway.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **JWT (JSON Web Token)**
- **Flyway (Migration de banco de dados)**
- **MySQL/PostgreSQL (ou outro banco de dados relacional de sua escolha)**
- **Maven**
- **Swagger (para documentação da API)**

## Funcionalidades

- Criar, listar, atualizar e excluir tarefas.
- Paginação e busca por título das tarefas.
- Segurança com autenticação JWT.
- Migração de banco de dados com Flyway.
- Relacionamento entre entidades.

## Requisitos

Antes de começar, certifique-se de ter o seguinte instalado:

- [JDK 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/) ou [PostgreSQL](https://www.postgresql.org/download/)
- [Git](https://git-scm.com/downloads)
  
## Instalação

### 1. Clone o Repositório

```bash
git clone https://github.com/jeanncarlos7/TaskFlow.git
cd taskflow
```

### 2. Configure o Banco de Dados

Crie um banco de dados no MySQL/PostgreSQL (ou outro banco de dados que você prefira). Em seguida, configure as credenciais no arquivo `application.properties` ou `application.yml`.

#### Exemplo (`application.properties`):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskflow_db
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Configure o JWT

No mesmo arquivo `application.properties` ou `application.yml`, adicione uma chave secreta para o JWT:

```properties
jwt.secret=sua_chave_secreta
jwt.expiration=3600000
```

### 4. Execute as Migrações Flyway

As migrações Flyway serão aplicadas automaticamente quando você rodar o projeto. Certifique-se de que seu banco de dados está conectado corretamente.

### 5. Build e Execute a Aplicação

Compile e execute a aplicação com o Maven:

```bash
mvn clean install
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## Endpoints

- `GET /api/tasks`: Lista todas as tarefas com paginação e busca por título.
- `GET /api/tasks/{id}`: Busca uma tarefa específica pelo ID.
- `POST /api/tasks`: Cria uma nova tarefa.
- `PUT /api/tasks/{id}`: Atualiza uma tarefa existente.
- `DELETE /api/tasks/{id}`: Deleta uma tarefa pelo ID.

### Documentação da API

A documentação da API está disponível via Swagger:

```
http://localhost:8080/swagger-ui.html
```

## Autenticação

A API está protegida com JWT. Para acessar os endpoints, você precisará:

1. Autenticar-se com as credenciais de login para obter um token JWT.
2. Incluir o token no cabeçalho `Authorization` para cada requisição protegida.

## Contribuindo

1. Fork este repositório.
2. Crie um branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`).
4. Envie seu branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

## Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

