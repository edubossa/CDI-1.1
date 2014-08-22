package br.com.ews.interceptor;

import java.util.UUID;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import static javax.interceptor.Interceptor.Priority.*;

@Priority(APPLICATION)
@Interceptor @Autenticacao 
public class AutenticacaoInterceptor {
	
	@AroundInvoke
	public Object autenticar(InvocationContext ctx) throws Exception {
		
		System.out.println("Interceptando o Metodo: " + ctx.getMethod().getName()); 
		
		String token = UUID.randomUUID().toString();
		System.out.println("Token de Acesso Enviado: " + token);
		ctx.getContextData().put("TOKEN_ACESSO", token);
		
		return ctx.proceed();
	}

}
