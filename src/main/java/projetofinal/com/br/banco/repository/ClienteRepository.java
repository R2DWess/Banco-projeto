package projetofinal.com.br.banco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projetofinal.com.br.banco.model.Cliente;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	

}
