package br.com.globalcode.interceptor;

import java.math.BigDecimal;
import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import static javax.interceptor.Interceptor.Priority.*;

@Priority(APPLICATION)
@Interceptor @Log
public class LogInterceptor {

    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception {
        String nome = ctx.getMethod().getName();
        if ("sacar".equals(nome)) {
            System.out.println("Realizando saque de R$" + extraiValor(ctx));
        } else if ("depositar".equals(nome)) {
            System.out.println("Realizando deposito de R$" + extraiValor(ctx));
        }
        return ctx.proceed();
    }
    
    private double extraiValor(InvocationContext ctx) {
        BigDecimal valor = (BigDecimal) ctx.getParameters()[0];
        return valor.doubleValue();
    }
}
