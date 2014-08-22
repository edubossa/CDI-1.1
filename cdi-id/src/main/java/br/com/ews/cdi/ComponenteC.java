package br.com.ews.cdi;

import javax.enterprise.context.Dependent;

@Dependent
public class ComponenteC {
	
	public void executaAcao() {
		System.out.println("ComponenteC#executaAcao()"); 
	}

}
