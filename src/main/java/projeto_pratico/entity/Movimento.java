package projeto_pratico.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MOVIMENTO")
public class Movimento {

	@Id
	@Column(name="CODIGO")
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name="CONTA_DESTINO")
	private Conta conta_destino;
	
	@ManyToOne
	@JoinColumn(name="CONTA_DESTINO")
	private Conta conta_origem;
	
	@Column(name="valor")
	private float valor;
	
	@Column(name="DATA")
	private Date data;
	
	@Column(name="TIPO")
	private String tipo;
	
	
	@Column(name="IMPOSTOS")
	private float impostos;
}
