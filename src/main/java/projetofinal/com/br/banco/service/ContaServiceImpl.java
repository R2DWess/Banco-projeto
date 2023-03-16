package projetofinal.com.br.banco.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import projetofinal.com.br.banco.model.Conta;
import projetofinal.com.br.banco.repository.ContaRepository;

@Component
public class ContaServiceImpl implements IContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Override
	public ArrayList<Conta> recuperarTodas() {
		return (ArrayList<Conta>) contaRepository.findAll();
	}

	@Override
	public Conta recuperarPeloNumero(int numero) {
		return contaRepository.findById(numero).orElse(null);
	}

	@Override
	public Conta alterarDados(Conta conta) {
		if (contaRepository.existsById(conta.getNumero())) {
			return contaRepository.save(conta);

		}
		return null;
	}

	@Override
	public ArrayList<Conta> recuperarContaPeloCliente(int idCliente) {
		return contaRepository.recuperarContaPeloCliente(idCliente);
	}

	@Override
	public Conta cadastrarConta(Conta conta) {
		return contaRepository.save(conta);
	}

}
