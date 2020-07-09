package projeto_pratico.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CONTA")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer numero;
	
	@Column(name="SALDO")
	private float saldo;
	
	@Column(name="DATA_ABERTURA")
	@Temporal(TemporalType.DATE)
	private Date data_abertura;
	
	@Column(name="NOME_TITULAR")
	private String nome_titular;
	
	@Column(name="CPF_TITULAR")
	private Integer cpf_titular;
	
	@Column(name="LIMITE_ESPECIAL")
	private float limite_especial;
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Date getData_abertura() {
		return data_abertura;
	}

	public void setData_abertura(Date data_abertura) {
		this.data_abertura = data_abertura;
	}

	public String getNome_titular() {
		return nome_titular;
	}

	public void setNome_titular(String nome_titular) {
		this.nome_titular = nome_titular;
	}

	public Integer getCpf_titular() {
		return cpf_titular;
	}

	public void setCpf_titular(Integer cpf_titular) {
		this.cpf_titular = cpf_titular;
	}

	public float getLimite_especial() {
		return limite_especial;
	}

	public void setLimite_especial(float limite_especial) {
		this.limite_especial = limite_especial;
	}
}
