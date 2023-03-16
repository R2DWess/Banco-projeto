package projetofinal.com.br.banco.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projetofinal.com.br.banco.model.Movimentacao;
import projetofinal.com.br.banco.service.IMovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private IMovimentacaoService movimentacaoService;

	@GetMapping("/extrato")
	public ResponseEntity<?> extrato(@RequestParam int idConta, @RequestParam LocalDate dataInicial,
			@RequestParam LocalDate dataFinal) {
		ArrayList<Movimentacao> movimentacoes = movimentacaoService.pegarExtrato(idConta, dataInicial, dataFinal);
		return ResponseEntity.ok().body(movimentacoes);
	}

	@PostMapping
	public ResponseEntity<Movimentacao> cadastrarMovimentacao(@RequestBody Movimentacao movimentacao) {
		Movimentacao novaMovimentacao = movimentacaoService.cadastrarMovimentacao(movimentacao);
		if (movimentacao != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(novaMovimentacao);
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{numeroConta}")
	public ResponseEntity<List<Movimentacao>> recuperarMovimentacoesPorConta(@PathVariable int numeroConta) {
		List<Movimentacao> movimentacoes = movimentacaoService.recuperarMovimentacaoConta(numeroConta);
		return ResponseEntity.ok(movimentacoes);
	}

	@PostMapping("/transferencia")
	public ResponseEntity<?> trasferirValores(@RequestParam("contaOrigem") int contaOrigem,
			@RequestParam("contaDestino") int contaDestino, @RequestParam("valor") double valor) {
		boolean transferencia = movimentacaoService.transferirValores(contaOrigem, contaDestino, valor);
		if (transferencia) {
			return ResponseEntity.ok("Transferência realizada com sucesso");
		}
		return ResponseEntity.badRequest().body("Transferência mal sucedida");
	}

}
