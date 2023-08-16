# App Portfolio (Codegroup): João Robson Jr
 

        Microsserviço Java Spring Boot que faz o gerenciamento de Projetos de uma Empresa (desafio Developer - CodeGroup). 
STACK:

* Java
* Spring Boot
* Apache Kafka
* PostgreSQL
* Docker

Para Rodar:
---------------------            
URL: (http://localhost:8080)
* CONTAINERS: PostgreSQL, Apache Kafka via containers Docker `docker compose up` em `.\src\main\resources\dockerfiles\`
* Via Java: ` java -jar .\target\codegroup-challenge-0.0.1-SNAPSHOT.jar`.
* Via Maven Wrapper: `{pasta raiz do projeto}> mvn -N io.takari:maven:wrapper` e então `mvnw clean spring-boot:run`.
---------------------

* Para visualizar o banco de dados (PostgreSQL): database `portfoliodb` porta `5432`  login `postgres` senha `postgres`

* API DOCs (Swagger): `http://localhost:8080/swagger-ui` / `http://localhost:8080/v2/api-docs`
* Collection Postman: `.\src\main\resources\restcollection\`
\
Tecnologias usadas na implementação:
\
Java Spring Boot / Maven / Spring JPA / Apache Kafka / Swagger / Lombok \
\
Observações: Faltando apenas a implementação da funcionalidade de adição de membro à um projeto (via consumer kafka).
-----------------

João Robson Reis Jr\
Senior Developer

16/08/2023
