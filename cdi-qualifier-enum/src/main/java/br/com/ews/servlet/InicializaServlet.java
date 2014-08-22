package br.com.ews.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ews.processos.IProcess;
import br.com.ews.processos.Process;
import br.com.ews.processos.ProcessType;

/**
 * Servlet implementation class InicializaServlet
 */
@WebServlet("/init")
public class InicializaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject @Process(type=ProcessType.ENVIAR_ARQUIVO_REMESSA)
	private IProcess process;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicializaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doAction(HttpServletRequest request, HttpServletResponse response) ... em execucao");
		
		process.executar();
	}
	

}
