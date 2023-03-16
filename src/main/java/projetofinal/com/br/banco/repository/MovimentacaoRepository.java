package projetofinal.com.br.banco.repository;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projetofinal.com.br.banco.model.Movimentacao;

@Repository
public interface MovimentacaoRepository extends CrudRepository<Movimentacao, Integer> {
	@Query("from Movimentacao where conta.numero= :numero")
	public ArrayList<Movimentacao> recuperarTodas(int numero);

	//@Query("from Movimentacao where conta.numero = :idConta and :dataInicial between :dataFinal")
	//public ArrayList<Movimentacao> pegarExtrato(int idConta, LocalDate dataInicial, LocalDate dataFinal);
	public ArrayList<Movimentacao> findByContaNumeroAndDataOperacaoBetween(int idConta, LocalDate dataInicial, LocalDate dataFinal);

}
