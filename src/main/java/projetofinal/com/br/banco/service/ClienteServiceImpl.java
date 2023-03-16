package projetofinal.com.br.banco.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import projetofinal.com.br.banco.model.Cliente;
import projetofinal.com.br.banco.repository.ClienteRepository;

@Component
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public ArrayList<Cliente> recuperarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Cliente recuperarPeloId(int id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public Cliente cadastrarCliente(Cliente cliente) {
		// TODO Auto-generated method stub

		return clienteRepository.save(cliente);
	}

	@Override
	public boolean transferirValores(int contaOrigem, int contaDestino, double valor) {
		// TODO Auto-generated method stub
		return false;
	}

}
