package com.example.wafi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class WafiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WafiApplication.class, args);
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> APPLICATION STARTED <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

	}

}
