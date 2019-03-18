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

@WebServlet("/PrepareEliminaCartellaServlet")
public class PrepareEliminaCartellaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public PrepareEliminaCartellaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		Long idCartella = Long.parseLong(request.getParameter("idCartella"));

		CartellaEsattoriale cartellaDaEliminare = cartellaEsattorialeService
				.caricaSingolaCartellaEsattoriale(idCartella);

		request.setAttribute("cartellaAttributeName", cartellaDaEliminare);

		RequestDispatcher rd = request.getRequestDispatcher("/cartella/eliminaForm.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
