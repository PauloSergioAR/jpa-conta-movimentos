import java.util.Calendar;

import projeto_pratico.dao.ContaDAO;
import projeto_pratico.dao.MovimentoDAO;
import projeto_pratico.entity.Conta;
import projeto_pratico.entity.Movimento;

public class Screnario4 {
	public static void main(String[] args) {
		
		Conta conta1 = new Conta();
		
		conta1.setCpf_titular("14413314555");
		conta1.setData_abertura(Calendar.getInstance().getTime());
		conta1.setLimite_especial(100f);
		conta1.setNome_titular("Paulo Scenario4");
		conta1.setSaldo(100f);
		
		Conta conta2 = new Conta();
		conta2.setCpf_titular("14413314444");
		conta2.setData_abertura(Calendar.getInstance().getTime());
		conta2.setLimite_especial(100f);
		conta2.setNome_titular("Paulo2 Scenario4");
		conta2.setSaldo(100f);
		
		Movimento movimento = new Movimento();
		
		movimento.setConta_origem(conta1);
		movimento.setConta_destino(conta2);
		movimento.setData(Calendar.getInstance().getTime());
		movimento.setImpostos(0.5f);
		movimento.setTipo("Doc");
		movimento.setValor(50f);
		
		ContaDAO.create(conta1);
		ContaDAO.create(conta2);
		MovimentoDAO.create(movimento);
		
		System.out.println(ContaDAO.getById(conta1.getNumero()).getNome_titular());
		conta1.setNome_titular("Nome alterado");
		ContaDAO.update(conta1);
		System.out.println(ContaDAO.getById(conta1.getNumero()).getNome_titular());
		
		System.out.println("Movimento: R$" + MovimentoDAO.getById(movimento.getCodigo()).getValor());
		movimento.setValor(100f);
		System.out.println("Movimento: R$" + MovimentoDAO.getById(movimento.getCodigo()).getValor());
		
	}
}
