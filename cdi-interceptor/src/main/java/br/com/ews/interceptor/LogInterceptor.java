package br.com.ews.interceptor;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import static javax.interceptor.Interceptor.Priority.*;

@Priority(APPLICATION + 10)
@Log 
@Interceptor
public class LogInterceptor {
	
	@AroundInvoke
	public Object log(InvocationContext ctx)  throws Exception{
		
		System.out.println("Interceptando o Metodo " + ctx.getMethod().getName());
		
		String token = (String) ctx.getContextData().get("TOKEN_ACESSO");
		System.out.println("Token Acesso Recebido: "  + token);
		
		return ctx.proceed();
		
	}

}
