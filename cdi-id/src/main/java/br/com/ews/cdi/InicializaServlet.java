package br.com.ews.cdi;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InicializaServlet
 * <p>
 * URL Acesso: http://localhost:8080/cdi-id/InicializaServlet
 */
@WebServlet("/InicializaServlet")
public class InicializaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private BeanController beanController;

    /**
     * Default constructor. 
     */
    public InicializaServlet() {
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
		System.out.println("Eduardo Wallace");
		beanController.acionaComponente();
	}

}
