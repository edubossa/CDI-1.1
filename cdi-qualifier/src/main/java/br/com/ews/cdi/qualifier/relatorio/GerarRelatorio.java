package br.com.ews.cdi.qualifier.relatorio;

import br.com.ews.cdi.qualifier.Relatorio;
import br.com.ews.command.Command;

@Relatorio
public class GerarRelatorio implements Command{

	public void executar() {
		
		System.out.println("Command GerarRelatorio em execucao ...");
		
	}

}
