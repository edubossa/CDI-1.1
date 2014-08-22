package br.com.ews.cdi;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class BeanController {
	
	@Inject
	ComponenteA componenteA;
	
	public void acionaComponente() {
		componenteA.realizarAtividade();
	}

}
