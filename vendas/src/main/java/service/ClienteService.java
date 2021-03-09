package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cliente;
import repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository repository;

	@Autowired
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}

	public void salvarCliente(Cliente cliente) {
		validarCliente(cliente);
		this.repository.salvar(cliente);
	}

	public void validarCliente(Cliente cliente) {

	}

}
