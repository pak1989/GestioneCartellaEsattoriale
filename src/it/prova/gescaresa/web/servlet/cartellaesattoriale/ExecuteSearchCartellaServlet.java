package it.prova.gescaresa.web.servlet.cartellaesattoriale;

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

import it.prova.gescaresa.model.CartellaEsattoriale;
import it.prova.gescaresa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.gescaresa.service.contribuente.ContribuenteService;

@WebServlet("/ExecuteSearchCartellaServlet")
public class ExecuteSearchCartellaServlet extends HttpServlet {
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

	public ExecuteSearchCartellaServlet() {
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

		String denominazione = request.getParameter("denominazioneInput");
		String descrizione = request.getParameter("descrizioneInput");
		String importo = request.getParameter("importoInput");

		CartellaEsattoriale example = new CartellaEsattoriale(denominazione, descrizione);

		Long idContribuente = Long.parseLong(request.getParameter("contribuenteIdInput"));
		
		if (idContribuente >= 0) {
			example.setContribuente(contribuenteService.caricaSingoloContribuente(idContribuente));
		}
		
		request.setAttribute("listaCartelleAttributeName",
				cartellaEsattorialeService.trovaByAllByAttribute(example, importo));

		RequestDispatcher rd = request.getRequestDispatcher("/cartella/searchResult.jsp");
		rd.forward(request, response);

	}
}