import java.util.Date;

import projeto_pratico.dao.ContaDAO;
import projeto_pratico.dao.MovimentoDAO;

public class Main {
	public static void main(String[] args) {
		Integer cpf1 = 1234;
		Integer cpf2 = 4556;
		
		ContaDAO.create(cpf1, "Paulo", new Date(), 150, 25);
		ContaDAO.create(cpf2, "Paula", new Date(), 100, 20);
	}
}
