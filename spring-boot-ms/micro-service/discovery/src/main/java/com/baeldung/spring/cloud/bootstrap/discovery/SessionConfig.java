package com.baeldung.spring.cloud.bootstrap.discovery;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
/*
We need to share sessions between different services in our system using
Spring Session. Sharing sessions enable logging users in our gateway
service and propagating that authentication to the other services.
*/
@EnableRedisHttpSession
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {
}
