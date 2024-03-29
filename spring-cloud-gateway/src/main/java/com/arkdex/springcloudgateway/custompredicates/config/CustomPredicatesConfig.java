package com.arkdex.springcloudgateway.custompredicates.config;

import com.arkdex.springcloudgateway.custompredicates.factories.GoldenCustomerRoutePredicateFactory;
import com.arkdex.springcloudgateway.custompredicates.factories.GoldenCustomerRoutePredicateFactory.Config;
import com.arkdex.springcloudgateway.custompredicates.service.GoldenCustomerService;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomPredicatesConfig {
    
    
    @Bean
    public GoldenCustomerRoutePredicateFactory goldenCustomer(GoldenCustomerService goldenCustomerService) {
        return new GoldenCustomerRoutePredicateFactory(goldenCustomerService);
    }
    

    //@Bean
    public RouteLocator routes(RouteLocatorBuilder builder, GoldenCustomerRoutePredicateFactory gf ) {

        return builder.routes()
          .route("dsl_golden_route", r -> r.path("/dsl_api/**")
            .filters(f -> f.stripPrefix(1))
            .uri("https://httpbin.org")
            .predicate(gf.apply(new Config(true, "customerId"))))
          .route("dsl_common_route", r -> r.path("/dsl_api/**")
            .filters(f -> f.stripPrefix(1))
            .uri("https://httpbin.org")
            .predicate(gf.apply(new Config(false, "customerId"))))             
          .build();
    }
    
}
