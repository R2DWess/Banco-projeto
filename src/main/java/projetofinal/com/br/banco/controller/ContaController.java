package projetofinal.com.br.banco.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import projetofinal.com.br.banco.model.Conta;
import projetofinal.com.br.banco.service.IContaService;

@RestController

public class ContaController {

	@Autowired
	private IContaService contaService;

	@GetMapping("/contas/{numero}")
	public ResponseEntity<Conta> buscarPorNumero(@PathVariable int numero) {
		Conta conta = contaService.recuperarPeloNumero(numero);
		if (conta != null) {
			return ResponseEntity.ok(conta);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/contas/cliente/{idCliente}")
	public ResponseEntity<List<Conta>> buscarPorCliente(@PathVariable int idCliente) {
		List<Conta> contas = contaService.recuperarContaPeloCliente(idCliente);
		if (!contas.isEmpty()) {
			return ResponseEntity.ok(contas);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/contas")
	public ResponseEntity<Conta> adicionarConta(@RequestBody Conta conta) {
		Conta contaSalva = contaService.cadastrarConta(conta);
		if (contaSalva != null) {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{numero}")
					.buildAndExpand(contaSalva.getNumero()).toUri();
			return ResponseEntity.created(location).body(contaSalva);
		}
		return ResponseEntity.badRequest().build();
	}

}
