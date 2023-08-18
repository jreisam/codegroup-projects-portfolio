# App Portfolio (Codegroup): João Robson Jr
 

Microsserviço Java Spring Boot que faz o gerenciamento de Projetos de uma Empresa (desafio Developer - CodeGroup). 
\
Mantem Projetos e Pessoas via REST HTTP, e adiciona Pessoas a Projetos via mensageria.

\
STACK:

* Java
* Spring Boot
* Apache Kafka
* PostgreSQL
* Docker

Para Rodar o Back-End:
---------------------            
URL: (http://localhost:8080)
* Containers: 
\
PostgreSQL, Apache Kafka: `docker compose up` em `.\src\main\resources\dockerfiles\`
* Aplicação Via Java: ` java -jar .\target\codegroup-challenge-0.0.1-SNAPSHOT.jar`.
* Aplicação Via Maven Wrapper: `{pasta raiz do projeto}> mvn -N io.takari:maven:wrapper` e então `mvnw clean spring-boot:run`.
---------------------

* Para visualizar o banco de dados (PostgreSQL): database `portfoliodb` porta `5432`  login `postgres` senha `postgres`

* API DOCs (Swagger): `http://localhost:8080/swagger-ui` / `http://localhost:8080/v2/api-docs`
* Collection Postman: `.\src\main\resources\restcollection\`
\


Para Rodar o Front-End:
---------------------            
URL: (http://localhost:4200)
* Angular Web App: `ng serve --open` em `.\src\main\webapp\angularclient\`

\
Tecnologias usadas na implementação:
\
Java Spring Boot / Maven / Spring JPA / Apache Kafka / Swagger / Lombok 

-----------------

João Robson Reis Jr\
Software Engineer

16/08/2023
