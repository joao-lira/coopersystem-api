package br.com.coopersystem.restapi;

import br.com.coopersystem.restapi.enuns.StRegistryActive;
import br.com.coopersystem.restapi.model.Client;
import br.com.coopersystem.restapi.repository.ClientsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.stream.LongStream;

@SpringBootApplication
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedOrigins("http://localhost:3031")
						.allowedMethods("GET", "POST","PUT", "DELETE");
			}
		};
	}
	/*
	@Bean
	CommandLineRunner init(ClientsRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						Client c = new Client();
						c.setClientName("João " + i);
						c.setClientCpf("02749571162");
						c.setClientCep("Client ");
						c.setClientLogradouro("Bloco T");
						c.setClientBairro("Guará 1");
						c.setClientCidade("Brasília");
						c.setClientUf("DF");
						c.setClientComplemento("Apartamento 103");
						c.setStActive((char) 1);
						c.setStRegistryActive(StRegistryActive.S);
						return c;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}
	 */
}
