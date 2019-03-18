package it.prova.gescaresa.web.servlet.utente;

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

import it.prova.gescaresa.model.Utente;
import it.prova.gescaresa.service.utente.UtenteService;

@WebServlet("/ExecuteEliminaUtenteServlet")
public class ExecuteEliminaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteEliminaUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!isUserAllowed(request)) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		Long idUtente = Long.parseLong(request.getParameter("idUtente"));

		utenteService.rimuovi(utenteService.caricaSingoloUtente(idUtente));

		RequestDispatcher rd = request.getRequestDispatcher("PrepareSearchUtenteServlet");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	private boolean isUserAllowed(HttpServletRequest request) {
		Utente userInSession = (Utente) request.getSession().getAttribute("userInfo");
		return userInSession != null && userInSession.isAdmin();
	}
}
