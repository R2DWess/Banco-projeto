package projetofinal.com.br.banco.service;

import java.util.ArrayList;

import projetofinal.com.br.banco.model.Cliente;

public interface IClienteService {
public ArrayList<Cliente> recuperarTodos();
public Cliente recuperarPeloId(int id);
public Cliente cadastrarCliente(Cliente cliente);
public boolean transferirValores(int contaOrigem, int contaDestino, double valor);
}
