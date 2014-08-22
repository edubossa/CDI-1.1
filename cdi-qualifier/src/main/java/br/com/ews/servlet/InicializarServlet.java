package br.com.ews.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ews.cdi.qualifier.Pagamento;
import br.com.ews.cdi.qualifier.Relatorio;
import br.com.ews.command.Command;

/**
 * Servlet implementation class InicializarServlet
 */
@WebServlet("/init")
public class InicializarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject @Pagamento
	private Command commandPagamento;
	
	@Inject @Relatorio
	private Command commandRelatorio;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public InicializarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doService() em execucao...");
		commandPagamento.executar();
		commandRelatorio.executar();
		
	}

}
