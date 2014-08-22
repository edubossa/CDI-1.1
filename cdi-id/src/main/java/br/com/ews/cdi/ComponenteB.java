package br.com.ews.cdi;

import javax.enterprise.context.Dependent;

@Dependent
public class ComponenteB {
	
	public void executaAcao() {
		System.out.println("ComponenteB#executaAcao()"); 
	}

}
