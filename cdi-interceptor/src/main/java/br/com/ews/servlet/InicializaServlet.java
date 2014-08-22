package br.com.ews.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ews.bean.ComponenteA;

/**
 * Servlet implementation class InicializaServlet
 * <p>
 * http://localhost:8080/cdi-interceptor/init
 */
@WebServlet("/init")
public class InicializaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private ComponenteA componenteA;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicializaServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		System.out.println("Executando o Metodo InicializaServlet#doAction..."); 
		componenteA.executaTarefa();
		
	}

}
