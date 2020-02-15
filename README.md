# spring-in-action
Practice in spring boot, tasks, feign, eureka, hystrix, zuul, sleuth, and stream calculations.
These sample projects are not only showing the features of spring frameworks, but also contain the thought 
on how to utilize it in enterprise applications.

##schedule-task
The @Scheduled help to create a schedule task, but how to stop/restart it, how java thread can support the multiple tasks?  
##eureka-server
Set up an eureka server for micro service registration, demo how to run in standalone or clustering.
##eureka-client
a client register to eureka server and provide service API 
##eureka-client-feign
a feign client find service API registered on eureka server and call it.
##eureka-zuul
use zuul server as API gateway
##messaging-rabbitmq
subscribe message from rabbitmq
##thread-pool
create thread pool, use BlockingQueue for inter thread data communication. 