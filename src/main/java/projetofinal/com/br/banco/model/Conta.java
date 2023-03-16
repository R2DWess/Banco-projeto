package projetofinal.com.br.banco.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbi_conta")
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_conta")
	private int numero;
	private int agencia;

// 1 - conta pessoa fisica
// 2 - conta estudantil
// 3 - conta salario
	@Column(name = "tipo_conta")
	private int tipo;
	private double saldo;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
