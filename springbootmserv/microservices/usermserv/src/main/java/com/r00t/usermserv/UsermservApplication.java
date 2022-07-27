package com.r00t.usermserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UsermservApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermservApplication.class, args);
	}

}
