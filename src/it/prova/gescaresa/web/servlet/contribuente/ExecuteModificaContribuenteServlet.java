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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gescaresa.model.Contribuente;
import it.prova.gescaresa.service.contribuente.ContribuenteService;
import it.prova.gescaresa.web.dto.contribuente.ContribuenteDTO;

@WebServlet("/ExecuteModificaContribuenteServlet")
public class ExecuteModificaContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaContribuenteServlet() {
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

		long idContribuente = Long.parseLong(request.getParameter("idInput"));
		String nome = request.getParameter("nomeInput");
		String cognome = request.getParameter("cognomeInput");
		int eta = Integer.parseInt(request.getParameter("etaInput"));
		String residenza = request.getParameter("residenzaInput");
		
		ContribuenteDTO contribuenteDTO = new ContribuenteDTO(StringUtils.trim(nome), StringUtils.trim(cognome), eta, residenza);
		List<String> validationMessageStrings = contribuenteDTO.validate();

		if (!validationMessageStrings.isEmpty()) {
			contribuenteDTO.setId(idContribuente);
			request.setAttribute("messaggiErrore", validationMessageStrings);
			request.setAttribute("contribuenteDto", contribuenteDTO);
			RequestDispatcher rd = request.getRequestDispatcher("/contribuente/modificaForm.jsp");
			rd.forward(request, response);
			return;
		}
		
		Contribuente contribuenteDaModificare = contribuenteService
				.caricaSingoloContribuenteConCartelleEsattoriali(idContribuente);

		contribuenteDaModificare.setNome(nome);
		contribuenteDaModificare.setCognome(cognome);
		contribuenteDaModificare.setEta(eta);
		contribuenteDaModificare.setResidenza(residenza);

		contribuenteService.aggiorna(contribuenteDaModificare);

		request.setAttribute("contribuenteAttributeName", contribuenteDaModificare);

		RequestDispatcher rd = request.getRequestDispatcher("/contribuente/dettaglio.jsp");
		rd.forward(request, response);
	}

}
