package projetofinal.com.br.banco.service;

import java.util.ArrayList;

import projetofinal.com.br.banco.model.Conta;

public interface IContaService {
	public ArrayList<Conta> recuperarTodas();

	public Conta recuperarPeloNumero(int numero);

	public Conta alterarDados(Conta conta);

	public ArrayList<Conta> recuperarContaPeloCliente(int idCliente);

	public Conta cadastrarConta(Conta conta);

}
