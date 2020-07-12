import java.util.Calendar;
import java.util.List;

import projeto_pratico.dao.ContaDAO;
import projeto_pratico.dao.MovimentoDAO;
import projeto_pratico.entity.Conta;
import projeto_pratico.entity.Movimento;

public class Scenario2 {
	public static void main(String[] args) {
		
		Conta conta1 = new Conta();
		
		conta1.setCpf_titular("14413314555");
		conta1.setData_abertura(Calendar.getInstance().getTime());
		conta1.setLimite_especial(100f);
		conta1.setNome_titular("Paulo Scenario2");
		conta1.setSaldo(100f);
		
		Conta conta2 = new Conta();
		conta2.setCpf_titular("14413314444");
		conta2.setData_abertura(Calendar.getInstance().getTime());
		conta2.setLimite_especial(100f);
		conta2.setNome_titular("Paulo2 Scenario2");
		conta2.setSaldo(100f);
		
		Movimento movimento = new Movimento();
		
		movimento.setConta_origem(conta1);
		movimento.setConta_destino(conta2);
		movimento.setData(Calendar.getInstance().getTime());
		movimento.setImpostos(0.5f);
		movimento.setTipo("Doc");
		movimento.setValor(50f);
		
		Movimento movimento2 = new Movimento();
		
		movimento2.setConta_origem(conta2);
		movimento2.setConta_destino(conta1);
		movimento2.setData(Calendar.getInstance().getTime());
		movimento2.setImpostos(0.5f);
		movimento2.setTipo("Doc");
		movimento2.setValor(75f);
		
		ContaDAO.create(conta1);
		ContaDAO.create(conta2);
		MovimentoDAO.create(movimento);
		MovimentoDAO.create(movimento2);
		
		List<Movimento> movimentos = MovimentoDAO.getMovimentosByConta(conta1);
		
		for(Movimento m : movimentos){
			System.out.println(m.toString());
		}
	}
}
