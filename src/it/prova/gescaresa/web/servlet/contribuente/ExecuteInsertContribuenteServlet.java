package it.prova.gescaresa.web.servlet.contribuente;

import java.io.IOException;
import java.util.List;

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
import it.prova.gescaresa.web.dto.contribuente.ContribuenteDTO;

@WebServlet("/ExecuteInsertContribuenteServlet")
public class ExecuteInsertContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInsertContribuenteServlet() {
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
		int eta = Integer.parseInt(request.getParameter("etaInput"));
		String residenza = request.getParameter("residenzaInput");

		ContribuenteDTO contribuenteDTO = new ContribuenteDTO(nome, cognome, eta, residenza);
		List<String> validationMessageStrings = contribuenteDTO.validate();

		if (!validationMessageStrings.isEmpty()) {
			request.setAttribute("messaggiErrore", validationMessageStrings);
			request.setAttribute("contribuenteDto", contribuenteDTO);
			RequestDispatcher rd = request.getRequestDispatcher("/contribuente/insertForm.jsp");
			rd.forward(request, response);
			return;
		}

		Contribuente contribuenteDaInserire = new Contribuente(nome, cognome, eta, residenza);

		contribuenteService.inserisciNuovo(contribuenteDaInserire);

		request.setAttribute("contribuenteAttributeName",
				contribuenteService.caricaSingoloContribuenteConCartelleEsattoriali(contribuenteDaInserire.getId()));

		RequestDispatcher rd = request.getRequestDispatcher("/contribuente/dettaglio.jsp");
		rd.forward(request, response);
	}

}
