package projeto_pratico.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto_pratico.entity.Conta;
import projeto_pratico.entity.Movimento;
import projeto_pratico.utils.HibernateUtil;

public class MovimentoDAO {
	public static EntityManager em = HibernateUtil.getEntityManager();
	
	public static Movimento create(Integer contaOrigem, Integer contaDestino, float valor, Date data, String tipo, float impostos) {
		Movimento m = new Movimento();
		
		m.setConta_origem(em.find(Conta.class, contaOrigem));
		m.setConta_destino(em.find(Conta.class, contaDestino));
		m.setValor(valor);
		m.setData(data);
		m.setTipo(tipo);
		m.setImpostos(impostos);
		
		
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		
		return em.find(Movimento.class, m.getCodigo());
	}
	
	public static Movimento create(Movimento m){
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		
		return em.find(Movimento.class, m.getCodigo());	
	}
	
	public static Movimento getById(Integer codigo) {
		return em.find(Movimento.class, codigo);
	}
	
	public static List<Movimento> getMovimentosByConta(Conta conta) {		
		Query q = em.createQuery("FROM Movimento where conta_origem = :conta OR conta_destino = :conta");
		q.setParameter("conta", conta);
		
		return (List<Movimento>) q.getResultList();			
	}
	
	
	public static void updateImpostos(Integer codigo, float impostos) {
		Movimento m =  em.find(Movimento.class, codigo);
		
		if(m != null) {
			m.setImpostos(impostos);
			em.getTransaction().begin();
			em.merge(m);
			em.getTransaction().commit();
		} else {
			System.out.println("Movimento nao encontrado");
		}
	}
	
	public static void delete(Integer codigo) {
		Movimento m = em.find(Movimento.class, codigo);
		
		if(m != null) {
			em.getTransaction().begin();
			em.remove(m);
			em.getTransaction().commit();
		} else {
			System.out.println("Movimento nao encontrado");
		}
	}
	
}
