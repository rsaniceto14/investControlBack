# Investments Control API - Spring boot Backend

>Para compilar o projeto use:
- mvn clean install
- mvn spring-boot:run

> RESTful API for managing investments with JWT authentication  
> **Stack:** Java 17, Spring Boot 3+, Spring Security, JPA (Hibernate), PostgreSQL, MongoDB (logs)

## Requisitos

 - Java 17+
 - Maven
 - PostgreSQL (Para o desenvolvimento foi utilizado neondb, pode ser usado localmente)
 - MongoDB     (foi utilizado o Altlas para os testes)

## Autenticação JWT 

## Endpoints Principais

### Auth

- POST  /auth/login  Login e token JWT 
  

### Investments 

- GET  /investments  &nbsp;&nbsp;&nbsp;       Lista todos investimentos.

- GET  /investments/{id}  &nbsp;&nbsp;&nbsp;  Detalha um investimento.

- POST /investments     &nbsp;&nbsp;&nbsp;    Cria novo investimento.

- PUT  /investments/{id}  &nbsp;&nbsp;&nbsp;  Edita um investimento.

- DELETE  /investments/{id} &nbsp;&nbsp;&nbsp; Deleta um investimento.

# Swagger

- Acesse [localhost](http://localhost:8080/swagger-ui/index.html)
- Faça login via /auth/login
- Clique em "Authorize"
- E insira o Bearer token
  

# Log de Erros no Mongo 

>Todas as exceções do sistemas são salvas no Mongo
>Documento no banco: logs