# eureka-server

## Basic structure
 1. Adding spring-cloud-starter-netflix-eureka-server to the dependencies
 2. Enable the Eureka Server in a @SpringBootApplication by annotating it with @EnableEurekaServer
 3. Define profile for standalone eureka server
 4. Define multi(peer1, peer2) for peer awareness
 5. To Run

## Run

mvn package

1.run the standalone server
java -jar -Dspring.profiles.active=single target/eureka-server-0.0.1-SNAPSHOT.jar


2.run the peer1 and peer2 for clustering
java -jar -Dspring.profiles.active=peer1 target/eureka-server-0.0.1-SNAPSHOT.jar

The console will show message:
...
com.netflix.discovery.shared.transport.TransportException: Cannot execute request on any known server
	at com.netflix.discovery.shared.transport.decorator.RetryableEurekaHttpClient.execute(RetryableEurekaHttpClient.java:112) ~[eureka-client-1.9.13.jar!/:1.9.13]
....
	
java -jar -Dspring.profiles.active=peer2 target/eureka-server-0.0.1-SNAPSHOT.jar

will see message:

2020-02-12 09:31:30.959  INFO 38038 --- [      Thread-10] c.n.e.r.PeerAwareInstanceRegistryImpl    : Got 1 instances from neighboring DS node