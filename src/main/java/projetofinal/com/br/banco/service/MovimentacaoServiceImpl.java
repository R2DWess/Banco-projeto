package projetofinal.com.br.banco.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import projetofinal.com.br.banco.model.Conta;
import projetofinal.com.br.banco.model.Movimentacao;
import projetofinal.com.br.banco.repository.MovimentacaoRepository;

@Component
public class MovimentacaoServiceImpl implements IMovimentacaoService {
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private IContaService service;

	@Override
	public Movimentacao cadastrarMovimentacao(Movimentacao movimentacao) {
		Conta c = service.recuperarPeloNumero(movimentacao.getConta().getNumero());
		if (c != null) {
			c.setSaldo(c.getSaldo() + movimentacao.getValor() * movimentacao.getTipoOperacao());
			service.alterarDados(c);
			return movimentacaoRepository.save(movimentacao);
		}
		return null;
	}

	@Override
	public ArrayList<Movimentacao> recuperarMovimentacaoConta(int numero) {
		// TODO Auto-generated method stub
		return movimentacaoRepository.recuperarTodas(numero);
	}

	@Override
	public boolean transferirValores(int contaOrigem, int contaDestino, double valor) {
		Conta contaOrigemObj = service.recuperarPeloNumero(contaOrigem);
		Conta contaDestinoObj = service.recuperarPeloNumero(contaDestino);

		if (contaOrigemObj != null && contaDestinoObj != null && contaOrigemObj.getSaldo() >= valor) {
			double novoSaldoOrigem = contaOrigemObj.getSaldo() - valor;
			double novoSaldoDestino = contaDestinoObj.getSaldo() + valor;

			contaOrigemObj.setSaldo(novoSaldoOrigem);
			contaDestinoObj.setSaldo(novoSaldoDestino);
			service.cadastrarConta(contaOrigemObj);
			service.cadastrarConta(contaDestinoObj);

			Movimentacao movOrigem = new Movimentacao();
			movOrigem.setTipoOperacao(-1);
			movOrigem.setDataOperacao(LocalDate.now());
			movOrigem.setDescricao("debito de transferencia");
			movOrigem.setValor(valor);
			movOrigem.setConta(contaOrigemObj);

			movimentacaoRepository.save(movOrigem);

			Movimentacao movDestino = new Movimentacao();
			movDestino.setTipoOperacao(1);
			movDestino.setDataOperacao(LocalDate.now());
			movDestino.setDescricao("credito de transferencia");
			movDestino.setValor(valor);
			movDestino.setConta(contaDestinoObj);

			movimentacaoRepository.save(movDestino);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<Movimentacao> pegarExtrato(int idConta, LocalDate dataInicial, LocalDate dataFinal) {
		return movimentacaoRepository.findByContaNumeroAndDataOperacaoBetween(idConta, dataInicial, dataFinal);
	}
}
