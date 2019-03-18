package it.prova.gescaresa.web.servlet.cartellaesattoriale;

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

import it.prova.gescaresa.model.CartellaEsattoriale;
import it.prova.gescaresa.model.Contribuente;
import it.prova.gescaresa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.gescaresa.service.contribuente.ContribuenteService;
import it.prova.gescaresa.web.dto.cartellaesattoriale.CartellaEsattorialeDTO;

@WebServlet("/ExecuteModificaCartellaServlet")
public class ExecuteModificaCartellaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;

	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaCartellaServlet() {
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

		Long idCartella = Long.parseLong(request.getParameter("idCartella"));

		Long idContribuente = Long.parseLong(request.getParameter("contribuenteIdInput"));
		String denominazione = request.getParameter("denominazioneInput");
		String descrizione = request.getParameter("descrizioneInput");
		int importo = Integer.parseInt(request.getParameter("importoInput"));
		Contribuente contribuente = contribuenteService.caricaSingoloContribuente(idContribuente);

		CartellaEsattorialeDTO cartellaDTO = new CartellaEsattorialeDTO(denominazione, descrizione, importo,
				contribuente);

		List<String> validationMessageStrings = cartellaDTO.validate();
		
		if (!validationMessageStrings.isEmpty()) {
			cartellaDTO.setId(idCartella);
			request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAllContribuenti());
			request.setAttribute("messaggiErrore", validationMessageStrings);
			request.setAttribute("cartellaDto", cartellaDTO);
			RequestDispatcher rd = request.getRequestDispatcher("/cartella/modificaForm.jsp");
			rd.forward(request, response);
			return;
		}

		CartellaEsattoriale cartellaDaModificare = cartellaEsattorialeService
				.caricaSingolaCartellaEsattoriale(idCartella);

		cartellaDaModificare.setDenominazione(denominazione);
		cartellaDaModificare.setDescrizione(descrizione);
		cartellaDaModificare.setImporto(importo);
		cartellaDaModificare.setContribuente(contribuente);

		cartellaEsattorialeService.aggiorna(cartellaDaModificare);

		request.setAttribute("cartellaAttributeName", cartellaDaModificare);

		RequestDispatcher rd = request.getRequestDispatcher("/cartella/dettaglio.jsp");
		rd.forward(request, response);
	}

}
