package br.com.ews.bean;

import javax.enterprise.context.Dependent;

@Dependent
public class ComponenteB {

	public void executaTarefa() {
		System.out.println("ComponenteB#executaTarefa()");
	}
	
}
