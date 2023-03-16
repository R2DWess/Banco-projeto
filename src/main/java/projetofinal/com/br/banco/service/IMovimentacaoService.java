package projetofinal.com.br.banco.service;

import java.time.LocalDate;
import java.util.ArrayList;

import projetofinal.com.br.banco.model.Movimentacao;

public interface IMovimentacaoService {
	public Movimentacao cadastrarMovimentacao(Movimentacao movimentacao);

	public ArrayList<Movimentacao> recuperarMovimentacaoConta(int numero);

	boolean transferirValores(int contaOrigem, int contaDestino, double valor);

	public ArrayList<Movimentacao> pegarExtrato(int idConta, LocalDate dataInicial, LocalDate dataFinal);
}
