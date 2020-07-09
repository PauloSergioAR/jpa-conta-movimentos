package projeto_pratico.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MOVIMENTO")
public class Movimento {
	
	@Id
	@GeneratedValue
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name="CONTA_DESTINO")
	private Conta conta_destino;
	
	@ManyToOne
	@JoinColumn(name="CONTA_ORIGEM")
	private Conta conta_origem;
	
	@Column(name="valor")
	private float valor;
	
	@Column(name="DATA")
	private Date data;
	
	@Column(name="TIPO")
	private String tipo;
	
	
	@Column(name="IMPOSTOS")
	private float impostos;

	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public Conta getConta_destino() {
		return conta_destino;
	}


	public void setConta_destino(Conta conta_destino) {
		this.conta_destino = conta_destino;
	}


	public Conta getConta_origem() {
		return conta_origem;
	}


	public void setConta_origem(Conta conta_origem) {
		this.conta_origem = conta_origem;
	}


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public float getImpostos() {
		return impostos;
	}


	public void setImpostos(float impostos) {
		this.impostos = impostos;
	}
}
