package projetofinal.com.br.banco.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projetofinal.com.br.banco.model.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Integer> {
	@Query("from Conta where cliente.id = :id")
	public ArrayList<Conta> recuperarContaPeloCliente(int id);

}
