package br.com.ews.processos;

@Process(type=ProcessType.DELETAR_ARQUIVO_TEMPORARIO)
public class DeletarArquivoTemporariosProcess implements IProcess {

	@Override
	public void executar() {
		
		System.out.println(" executar() ... DeletarArquivoTemporariosProcess! ");
		
	}

}
