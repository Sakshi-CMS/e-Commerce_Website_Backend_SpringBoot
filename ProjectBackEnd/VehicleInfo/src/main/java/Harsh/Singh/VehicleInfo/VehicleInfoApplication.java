package Harsh.Singh.VehicleInfo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VehicleInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleInfoApplication.class, args);
	}

}
