package br.com.ews.processos;

@Process(type=ProcessType.ATUALIZAR_BASE_DADOS)
public class AtualizarBaseDadosProcess implements IProcess {

	@Override
	public void executar() {
		
		System.out.println(" executar() ... AtualizarBaseDadosProcess! ");
		
	}

}
