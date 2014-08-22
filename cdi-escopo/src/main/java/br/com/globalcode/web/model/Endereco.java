package br.com.globalcode.web.model;

import java.io.Serializable;

public class Endereco implements Serializable {
	private static final long serialVersionUID = 974943540345237947L;

	private String rua;
	private String complemento;
	private String cep;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", complemento=" + complemento
				+ ", cep=" + cep + "]";
	}

}