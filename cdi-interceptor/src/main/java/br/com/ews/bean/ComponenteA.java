package br.com.ews.bean;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import br.com.ews.interceptor.Autenticacao;
import br.com.ews.interceptor.Log;

@Dependent
@Log
@Autenticacao
public class ComponenteA {
	
	@Inject
	private ComponenteB componenteB;
	
	public void executaTarefa() {
		System.out.println("ComponenteA#executaTarefa()");
		componenteB.executaTarefa();
	}
	
	
}
