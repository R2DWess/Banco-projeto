package projetofinal.com.br.banco.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetofinal.com.br.banco.model.Cliente;
import projetofinal.com.br.banco.service.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService service;

	@GetMapping
	public ResponseEntity<ArrayList<Cliente>> listarClientes() {
		ArrayList<Cliente> cliente = service.recuperarTodos();
		return ResponseEntity.ok(cliente);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable int id) {
		Cliente cliente = service.recuperarPeloId(id);
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Cliente> adicionarCliente(@RequestBody Cliente cliente) {
		Cliente clienteAdicionado = service.cadastrarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteAdicionado);
	}

}
