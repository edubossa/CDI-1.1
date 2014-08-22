package br.com.ews.cdi;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class ComponenteA {
	
	@Inject
	private ComponenteB componenteB;
	
	@Inject
	private ComponenteC componenteC;
	
	public void realizarAtividade() {
		System.out.println("ComponenteA#realizarAtividade()");
		componenteB.executaAcao();
		componenteC.executaAcao();
	}

}
