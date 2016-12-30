package com.demo.sample.service.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SampleServiceCApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleServiceCApplication.class, args);
	}
}
