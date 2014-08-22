package br.com.globalcode.web.controller;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.globalcode.web.model.Cliente;

@Named("cadastroMB")
@ConversationScoped
public class CadastroController implements Serializable{
	private static final long serialVersionUID = 1740167420279608454L;

	@Inject
	private Conversation conversation;

	private Cliente cliente = new Cliente();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Conversation getConversation() {
		return conversation;
	}
	
	public String iniciar() {
		
		//Inicializa o escopo de conversacao caso nao esteja iniciado
		if(conversation.isTransient()) {
			conversation.begin();
		}
		System.out.println(cliente);
		return "cadastraEndereco";
	}
	
	public String salvar(){
		System.out.println("Cadastrando os dados do cliente!!!");
		
		//Finaliza o escopo de conversacao caso esteja iniciado
		if(!conversation.isTransient()) {
			conversation.end();
		}
		
		System.out.println(cliente);
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Cliente Cadastrado com Sucesso!!!"));
		
		
		return "confirmacao";
	}
	
	
}
