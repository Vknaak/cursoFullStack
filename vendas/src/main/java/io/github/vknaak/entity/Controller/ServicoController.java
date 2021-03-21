package io.github.vknaak.entity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.vknaak.entity.Servico;
import io.github.vknaak.repository.ServicoRepository;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {
	
	private final ServicoRepository repository;

	@Autowired
	public ServicoController(ServicoRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico salvar(@RequestBody Servico servico) {
		return repository.save(servico);
	}
	

}
