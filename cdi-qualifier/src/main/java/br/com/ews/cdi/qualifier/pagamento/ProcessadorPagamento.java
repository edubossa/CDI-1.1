package br.com.ews.cdi.qualifier.pagamento;

import br.com.ews.cdi.qualifier.Pagamento;
import br.com.ews.command.Command;

@Pagamento
public class ProcessadorPagamento implements Command {

	public void executar() {
		
		System.out.println("Command ProcessadorPagamento em execucao ...");
	}

}
