import java.util.Calendar;

import projeto_pratico.dao.ContaDAO;
import projeto_pratico.dao.MovimentoDAO;
import projeto_pratico.entity.Conta;
import projeto_pratico.entity.Movimento;

public class Scenario1 {
	public static void main(String[] args) {
		Conta conta1 = new Conta();
		
		conta1.setCpf_titular("14413314417");
		conta1.setData_abertura(Calendar.getInstance().getTime());
		conta1.setLimite_especial(100f);
		conta1.setNome_titular("Paulo");
		conta1.setSaldo(100f);
		
		Conta conta2 = new Conta();
		conta2.setCpf_titular("14413314417");
		conta2.setData_abertura(Calendar.getInstance().getTime());
		conta2.setLimite_especial(100f);
		conta2.setNome_titular("Paulo2");
		conta2.setSaldo(100f);
		
		Movimento movimento = new Movimento();
		
		movimento.setConta_origem(conta1);
		movimento.setConta_destino(conta2);
		movimento.setData(Calendar.getInstance().getTime());
		movimento.setImpostos(0.5f);
		movimento.setTipo("TED");
		movimento.setValor(50f);
		
		ContaDAO.create(conta1);
		ContaDAO.create(conta2);
		MovimentoDAO.create(movimento);
	}
}
