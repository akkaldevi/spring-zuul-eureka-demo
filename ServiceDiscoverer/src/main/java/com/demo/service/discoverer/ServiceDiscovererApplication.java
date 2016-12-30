package com.demo.service.discoverer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;


// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.http.ResponseEntity;
// import org.springframework.http.HttpStatus;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceDiscovererApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscovererApplication.class, args);
	}
}

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/show-service-instances")
    public List<ServiceInstance> serviceInstancesByApplicationName() {
        // return this.discoveryClient.getInstances(applicationName);

				List<String> services = discoveryClient.getServices();
				List<ServiceInstance> serviceInstanceLists = new ArrayList<>();
				for(String serviceName: services){
						serviceInstanceLists.addAll(discoveryClient.getInstances(serviceName));
				}
				return serviceInstanceLists;
    }
}

// // @RestController
// // class WhoAmI {
// //     @RequestMapping(path="/whoAmI", method=RequestMethod.GET)
// //     public ResponseEntity<String> whoAmI() {
// //         String response = "I am sample-service-a !!";
// //         return new ResponseEntity<String>(response, HttpStatus.OK);
// //     }
// // }
//
//
//
//
//
//
//
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
//
// @SpringBootApplication
// public class ServiceDiscovererApplication {
//
// 	public static void main(String[] args) {
// 		SpringApplication.run(ServiceDiscovererApplication.class, args);
// 	}
// }
