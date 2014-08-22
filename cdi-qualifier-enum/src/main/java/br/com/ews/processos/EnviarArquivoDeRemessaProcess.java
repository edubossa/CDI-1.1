package br.com.ews.processos;

@Process(type=ProcessType.ENVIAR_ARQUIVO_REMESSA)
public class EnviarArquivoDeRemessaProcess implements IProcess {

	@Override
	public void executar() {
		
		System.out.println(" executar() ... EnviarArquivoDeRemessaProcess! ");
		
	}

}
