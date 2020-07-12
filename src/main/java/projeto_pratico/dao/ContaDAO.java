package projeto_pratico.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import projeto_pratico.entity.Conta;
import projeto_pratico.utils.HibernateUtil;

public class ContaDAO {

	public static EntityManager em = HibernateUtil.getEntityManager();
	
	public static Conta create(String cpf, String nome, Date data_abertura, float limite_especial, float saldo) {
		Conta c = new Conta();
		
		c.setCpf_titular(cpf);
		c.setNome_titular(nome);
		c.setData_abertura(data_abertura);
		c.setLimite_especial(limite_especial);
		c.setSaldo(saldo);
		
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		return em.find(Conta.class, c.getNumero());
	}
	
	public static Conta create(Conta c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		return em.find(Conta.class, c.getNumero());
	}
	
	public static Conta getById(Integer numero) {
		Conta c = em.find(Conta.class, numero);
		
		return c;
	}
	
	public static void update(Conta conta) {
		em.getTransaction().begin();
		em.merge(conta);
		em.getTransaction().commit();
		
	}
	
	public static void delete (Integer numero) {
		Conta c = em.find(Conta.class, numero);
		
		if(c != null) {
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();
		}
	}
}
