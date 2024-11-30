package com.videoclub.videoclub;

import controlador.impl.AlquilerControlador;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.videoclub.videoclub", "controlador.impl"})
public class VideoclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoclubApplication.class, args);
	}

}
