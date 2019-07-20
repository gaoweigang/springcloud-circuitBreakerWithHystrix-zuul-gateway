package com.gwg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 注解@EnableDiscoveryClient，@EnableEurekaClient的区别
 SpringCLoud中的“Discovery Service”有多种实现，比如：eureka, consul, zookeeper。
 1，@EnableDiscoveryClient注解是基于spring-cloud-commons依赖，并且在classpath中实现；
 2，@EnableEurekaClient注解是基于spring-cloud-netflix依赖，只能为eureka作用；
 如果你的classpath中添加了eureka，则它们的作用是一样的。


 因为我在classpath中添加了Eureka，所以在这里这两个注解的作用一样
 */
@SpringBootApplication
//@EnableDiscoveryClient
/**
 * 1.Eureka客户端服务提供者
 *
 * 启动Eureka服务，Eureka客户端与服务器端都需要使用该注解，至于是否需要将该应用中的服务注册到服务注册中心是由配置文件配置的
 */
@EnableEurekaClient //
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class);
    }
}