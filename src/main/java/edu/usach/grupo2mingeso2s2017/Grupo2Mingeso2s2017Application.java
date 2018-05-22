package edu.usach.grupo2mingeso2s2017;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;


@SpringBootApplication
@EnableOAuth2Sso
public class Grupo2Mingeso2s2017Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo2Mingeso2s2017Application.class, args);
	}
}
