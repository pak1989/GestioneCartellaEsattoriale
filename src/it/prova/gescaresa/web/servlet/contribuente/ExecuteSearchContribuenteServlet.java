package it.prova.gescaresa.web.servlet.contribuente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gescaresa.model.Contribuente;
import it.prova.gescaresa.service.contribuente.ContribuenteService;

@WebServlet("/ExecuteSearchContribuenteServlet")
public class ExecuteSearchContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteSearchContribuenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		String nome = request.getParameter("nomeInput");
		String cognome = request.getParameter("cognomeInput");
		String eta = request.getParameter("etaInput");
		String residenza = request.getParameter("residenzaInput");

		Contribuente example = new Contribuente(nome, cognome, residenza);

		request.setAttribute("listaContribuentiAttributeName", contribuenteService.trovaAllByAttribute(example, eta));

		RequestDispatcher rd = request.getRequestDispatcher("/contribuente/searchResult.jsp");
		rd.forward(request, response);

	}

}
