package io.github.vknaak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import io.github.vknaak.entity.Cliente;
import io.github.vknaak.repository.ClienteRepository;

@SpringBootApplication
@RestController
public class VendasAplication {

	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository repository) {
		return args -> {
			Cliente cliente = Cliente.builder().cpf("75973227049").nome("Vilson").build();
			repository.save(cliente);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasAplication.class, args);
	}

}
