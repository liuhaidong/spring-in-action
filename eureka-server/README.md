# eureka-server

## 1. Adding spring-cloud-starter-netflix-eureka-server to the dependencies
## 2. Enable the Eureka Server in a @SpringBootApplication by annotating it with @EnableEurekaServer
## 3. Define profile for standalone eureka server
## 4. Define multi(peer1, peer2) for peer awareness
## 5. To Run

mvn package
  
java -jar -Dspring.profiles.active=single target/eureka-server-0.0.1-SNAPSHOT.jar
 