package com.baeldung.spring.cloud.bootstrap.svcrating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.sleuth.metric.SpanMetricReporter;
import org.springframework.cloud.sleuth.zipkin.HttpZipkinSpanReporter;
import org.springframework.cloud.sleuth.zipkin.ZipkinProperties;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;

import zipkin.Span;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableTransactionManagement(order=Ordered.LOWEST_PRECEDENCE, mode=AdviceMode.ASPECTJ)
public class RatingServiceApplication {
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private SpanMetricReporter spanMetricReporter;
    @Autowired
    private ZipkinProperties zipkinProperties;
    @Value("${spring.sleuth.web.skipPattern}")
    private String skipPattern;

    public static void main(String[] args) {
        SpringApplication.run(RatingServiceApplication.class, args);
    }

    /*
    Contract for reporting Zipkin spans to Zipkin.
    */
    @Bean
    public ZipkinSpanReporter makeZipkinSpanReporter() {
        return new ZipkinSpanReporter() {
            private HttpZipkinSpanReporter delegate;
            private String baseUrl;
    
            /*
            Receives completed spans from ZipkinSpanListener and submits them to a Zipkin collector.
            */
            @Override
            public void report(Span span) {
                InstanceInfo instance = eurekaClient.getNextServerFromEureka("zipkin", false);
                if (!(baseUrl != null && instance.getHomePageUrl().equals(baseUrl))) {
                    baseUrl = instance.getHomePageUrl();
                    delegate = new HttpZipkinSpanReporter(new RestTemplate(), baseUrl, zipkinProperties.getFlushInterval(), spanMetricReporter);
                    if (!span.name.matches(skipPattern)) delegate.report(span);
                }
                if (!span.name.matches(skipPattern)) delegate.report(span);
            }
        };
    }
    
    /*
    Hystrix is a latency and fault tolerance library designed to isolate points of access to remote systems,
     services and 3rd party libraries, stop cascading failure
    */
    @Bean
    @Primary
    @Order(value=Ordered.HIGHEST_PRECEDENCE)
    public HystrixCommandAspect hystrixAspect() {
      return new HystrixCommandAspect();
    }
}