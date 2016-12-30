package com.demo.sample.service.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@EnableDiscoveryClient
@SpringBootApplication
public class SampleServiceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleServiceAApplication.class, args);
	}
}

@RestController
class WelcomeService{
  @RequestMapping("/resources/welcomeMsg")
	public ResponseEntity<?> welcome(){
		return new ResponseEntity<>("Hi, i am from service-a", HttpStatus.OK);

	}
}
